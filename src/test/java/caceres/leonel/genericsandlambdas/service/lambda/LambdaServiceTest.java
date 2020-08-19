package caceres.leonel.genericsandlambdas.service.lambda;

import caceres.leonel.genericsandlambdas.dto.CSV;
import caceres.leonel.genericsandlambdas.entity.Person;
import caceres.leonel.genericsandlambdas.entity.Pet;
import caceres.leonel.genericsandlambdas.repository.PersonRepository;
import caceres.leonel.genericsandlambdas.repository.PetRepository;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class LambdaServiceTest {

    @Autowired
    LambdaService lambdaService;

    @Autowired
    PersonRepository personRepository;

    @Autowired
    PetRepository petRepository;

    @Test
    void saveCSV() {
        CSV line1 = new CSV();
        line1.setPersonName("personName");
        line1.setPersonLastName("personLastName");
        line1.setPersonEmail("email@test.com");
        line1.setPetName("petName");

        CSV line2 = new CSV();
        line2.setPersonName("personName2");
        line2.setPersonLastName("personLastName2");
        line2.setPersonEmail("email2@test.com");
        line2.setPetName("petName2");

        lambdaService.saveCSV(Lists.list(line1, line2));

        List<Person> persons = personRepository.findAll();
        List<Pet> pets = petRepository.findAll();

        assertEquals(2, persons.size());
        assertEquals(2, pets.size());
        assertTrue(persons.stream().anyMatch(person -> line1.getPersonName().equals(person.getName())));
        assertTrue(persons.stream().anyMatch(person -> line1.getPersonLastName().equals(person.getLastName())));
        assertTrue(persons.stream().anyMatch(person -> line1.getPersonEmail().equals(person.getEmail())));
        assertTrue(pets.stream().anyMatch(pet -> line1.getPetName().equals(pet.getName())));
        assertTrue(persons.stream().anyMatch(person -> line2.getPersonName().equals(person.getName())));
        assertTrue(persons.stream().anyMatch(person -> line2.getPersonLastName().equals(person.getLastName())));
        assertTrue(persons.stream().anyMatch(person -> line2.getPersonEmail().equals(person.getEmail())));
        assertTrue(pets.stream().anyMatch(pet -> line2.getPetName().equals(pet.getName())));
    }
}