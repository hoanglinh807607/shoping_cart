package javaframework.demo.converter;

import javaframework.demo.dto.AbstractDTO;
import javaframework.demo.entities.BaseEntity;
import org.springframework.stereotype.Component;

@Component
public class AbstractConverter<T extends AbstractDTO> {
    public T toDto(T abstractDTO,BaseEntity entity) {
        abstractDTO.setCreatedDate(entity.getCreatedDate());
        abstractDTO.setCreatedBy(entity.getCreatedBy());
        abstractDTO.setModifiedDate(entity.getModifiedDate());
        abstractDTO.setModifiedBy(entity.getModifiedBy());
        abstractDTO.setStatus(entity.getStatus());
        abstractDTO.setId(entity.getId());
        return abstractDTO;

    }


}