package javaframework.demo.converter;

import javaframework.demo.dto.AbstractDTO;
import javaframework.demo.entities.BaseEntity;
import org.springframework.stereotype.Component;

@Component
public class AbstractCoverter {
    public AbstractDTO toDto(BaseEntity entity) {
        AbstractDTO abstractDTO = new AbstractDTO();
        abstractDTO.setCreatedDate(entity.getCreatedDate());
        abstractDTO.setCreatedBy(entity.getCreatedBy());
        abstractDTO.setModifiedDate(entity.getModifiedDate());
        abstractDTO.setModifiedBy(entity.getModifiedBy());
        abstractDTO.setStatus(entity.getStatus());
        abstractDTO.setId(entity.getId());

        return abstractDTO;

    }

    public BaseEntity toEntity(AbstractDTO dto) {
        BaseEntity entity = new BaseEntity();
        entity.setCreatedBy(dto.getCreatedBy());
        entity.setModifiedBy(dto.getModifiedBy());
        entity.setCreatedDate(dto.getCreatedDate());
        entity.setModifiedDate(dto.getModifiedDate());
        entity.setStatus(dto.getStatus());
          return entity;
    }

}