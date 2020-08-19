package caceres.leonel.genericsandlambdas.helper.basic;

import caceres.leonel.genericsandlambdas.dto.PersonDTO;
import caceres.leonel.genericsandlambdas.entity.Person;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TransformerTest {

    Transformer transformer = new Transformer();

    @Test
    public void mapPersonEntityToPersonDTO() {
        Person person = new Person();
        person.setId(1L);
        person.setName("testName");
        person.setLastName("testLastName");
        person.setEmail("email@test.com");

        PersonDTO personDTO = transformer.mapPersonEntityToPersonDTO(person);

        assertEquals(person.getId(), personDTO.getId());
        assertEquals(person.getName(), personDTO.getName());
        assertEquals(person.getLastName(), personDTO.getLastName());
        assertEquals(person.getEmail(), personDTO.getEmail());
    }

    @Test
    public void mapPersonDTOToPersonEntity() {
        PersonDTO personDTO = new PersonDTO();
        personDTO.setId(1L);
        personDTO.setName("testName");
        personDTO.setLastName("testLastName");
        personDTO.setEmail("email@test.com");

        Person person = transformer.mapPersonDTOToPersonEntity(personDTO);

        assertEquals(personDTO.getId(), person.getId());
        assertEquals(personDTO.getName(), person.getName());
        assertEquals(personDTO.getLastName(), person.getLastName());
        assertEquals(personDTO.getEmail(), person.getEmail());
    }
}