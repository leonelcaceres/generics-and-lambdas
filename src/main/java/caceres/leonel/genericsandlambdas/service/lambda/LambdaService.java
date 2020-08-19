package caceres.leonel.genericsandlambdas.service.lambda;

import caceres.leonel.genericsandlambdas.dto.CSV;
import caceres.leonel.genericsandlambdas.entity.Person;
import caceres.leonel.genericsandlambdas.entity.Pet;
import caceres.leonel.genericsandlambdas.repository.PersonRepository;
import caceres.leonel.genericsandlambdas.repository.PetRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;

@Service
@AllArgsConstructor
@Slf4j
public class LambdaService {

    private final PersonRepository personRepository;
    private final PetRepository petRepository;

    public void saveCSV(List<CSV> csvList) {
        csvList.forEach(csv -> {
            processEntity(
                    () -> buildPerson(csv.getPersonName(), csv.getPersonLastName(), csv.getPersonEmail()),
                    personRepository::save,
                    "person"
            );

            processEntity(
                    () -> buildPet(csv.getPetName()),
                    petRepository::save,
                    "pet"
            );
        });
    }

    private <ENTITY> void processEntity(Supplier<ENTITY> buildEntity, Consumer<ENTITY> saveEntity, String entityType) {
        try {
            ENTITY entity = buildEntity.get();
            saveEntity.accept(entity);

            log.info("{} saved", entityType);
        }catch (Exception e) {
            log.error("error processing {}", entityType);
        }
    }

    private Person buildPerson(String name, String lastName, String email) {
        Person person = new Person();
        person.setName(name);
        person.setLastName(lastName);
        person.setEmail(email);

        return person;
    }

    private Pet buildPet(String name) {
        Pet pet = new Pet();
        pet.setName(name);

        return pet;
    }

}