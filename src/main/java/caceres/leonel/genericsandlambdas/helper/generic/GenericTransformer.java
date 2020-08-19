package caceres.leonel.genericsandlambdas.helper.generic;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class GenericTransformer {

    private final ModelMapper modelMapper = new ModelMapper();

    @PostConstruct
    public void init() {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
    }

    public <ENTITY, DTO> DTO mapEntityToDTO(ENTITY entity, Class<DTO> dto) {
        return modelMapper.map(entity, dto);
    }

    public <DTO, ENTITY> ENTITY mapDTOToEntity(DTO dto, Class<ENTITY> entity) {
        return modelMapper.map(dto, entity);
    }

}