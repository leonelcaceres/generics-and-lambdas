package caceres.leonel.genericsandlambdas.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PersonDTO {
    private Long id;
    private String name;
    private String lastName;
    private String email;
}