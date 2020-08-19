package caceres.leonel.genericsandlambdas.helper.generic;

import caceres.leonel.genericsandlambdas.dto.PersonDTO;
import caceres.leonel.genericsandlambdas.entity.Person;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GenericTransformerTest {

    GenericTransformer transformer = new GenericTransformer();

    @Test
    public void mapPersonEntityToPersonDTO() {
        Person person = new Person();
        person.setId(1L);
        person.setName("testName");
        person.setLastName("testLastName");
        person.setEmail("email@test.com");

        PersonDTO personDTO = transformer.mapEntityToDTO(person, PersonDTO.class);

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

        Person person = transformer.mapDTOToEntity(personDTO, Person.class);

        assertEquals(personDTO.getId(), person.getId());
        assertEquals(personDTO.getName(), person.getName());
        assertEquals(personDTO.getLastName(), person.getLastName());
        assertEquals(personDTO.getEmail(), person.getEmail());
    }
}