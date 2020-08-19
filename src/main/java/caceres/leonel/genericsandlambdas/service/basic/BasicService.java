package caceres.leonel.genericsandlambdas.service.basic;

import caceres.leonel.genericsandlambdas.dto.CSV;
import caceres.leonel.genericsandlambdas.entity.Person;
import caceres.leonel.genericsandlambdas.entity.Pet;
import caceres.leonel.genericsandlambdas.repository.PersonRepository;
import caceres.leonel.genericsandlambdas.repository.PetRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class BasicService {

    private final PersonRepository personRepository;
    private final PetRepository petRepository;

    public void saveCSV(List<CSV> csvList) {
        csvList.forEach(csv -> {
            try {
                processPerson(csv.getPersonName(), csv.getPersonLastName(), csv.getPersonEmail());
            }catch (Exception e) {
                log.error("error processing preson");
            }

            try {
                processPet(csv.getPetName());
            }catch (Exception e) {
                log.error("error processing pet");
            }
        });
    }

    private void processPerson(String name, String lastName, String email) {
        Person person = buildPerson(name, lastName, email);
        personRepository.save(person);

        log.info("Person saved");
    }

    private Person buildPerson(String name, String lastName, String email) {
        Person person = new Person();
        person.setName(name);
        person.setLastName(lastName);
        person.setEmail(email);

        return person;
    }

    private void processPet(String name) {
        Pet pet = buildPet(name);
        petRepository.save(pet);

        log.info("Pet saved");
    }

    private Pet buildPet(String name) {
        Pet pet = new Pet();
        pet.setName(name);

        return pet;
    }
}