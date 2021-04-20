package javaframework.demo.converter;

import javaframework.demo.dto.AttributeDTO;
import javaframework.demo.entities.AttributeEntity;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;

@Component
public class AttributeConverter extends AbstractConverter<AttributeDTO> {
    public AttributeDTO toDto(AttributeEntity entity) {
        AttributeDTO dto = new AttributeDTO();
        dto.setName(entity.getName());
        return toDto(dto,entity);
    }

    public AttributeEntity toEntity(AttributeDTO dto) {
        AttributeEntity entity = new AttributeEntity();
        return getAttributeEntity(entity,dto);
    }

    public AttributeEntity toEntity(AttributeEntity entity, AttributeDTO dto) {
        return getAttributeEntity(entity,dto);
    }

    @NotNull
    private AttributeEntity getAttributeEntity(AttributeEntity entity, AttributeDTO dto) {
        entity.setName(dto.getName());
        if( dto.getStatus() != null ) entity.setStatus(dto.getStatus());
        else entity.setStatus(0);
        return entity;
    }
}
