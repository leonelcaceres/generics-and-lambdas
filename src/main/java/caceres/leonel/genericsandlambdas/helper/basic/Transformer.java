package caceres.leonel.genericsandlambdas.helper.basic;

import caceres.leonel.genericsandlambdas.dto.PersonDTO;
import caceres.leonel.genericsandlambdas.dto.PetDTO;
import caceres.leonel.genericsandlambdas.entity.Person;
import caceres.leonel.genericsandlambdas.entity.Pet;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class Transformer {

    private final ModelMapper modelMapper = new ModelMapper();

    @PostConstruct
    public void init() {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
    }

    public PersonDTO mapPersonEntityToPersonDTO(Person person) {
        return modelMapper.map(person, PersonDTO.class);
    }

    public Person mapPersonDTOToPersonEntity(PersonDTO personDTO) {
        return modelMapper.map(personDTO, Person.class);
    }

    public PetDTO mapPetEntityToPetDTO(Pet pet) {
        return modelMapper.map(pet, PetDTO.class);
    }

    public Pet mapPetDTOToPetEntity(PetDTO petDTO) {
        return modelMapper.map(petDTO, Pet.class);
    }

}