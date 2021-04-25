package javaframework.demo.converter;

import javaframework.demo.dto.AttributeValueDTO;
import javaframework.demo.entities.AttributeValueEntity;
import javaframework.demo.repository.AttributeRepos;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AttributeValueConverter extends AbstractConverter<AttributeValueDTO> implements IAbstractConverter<AttributeValueDTO, AttributeValueEntity>{

    @Autowired
    private AttributeRepos attributeRepos;

    @Override
    public AttributeValueDTO toDto(AttributeValueEntity entity) {
        AttributeValueDTO dto = new AttributeValueDTO();
        dto.setValue(entity.getValue());
        dto.setAttributeId(entity.getAttributeEntity().getId());
        return toDto(dto,entity);
    }

    @Override
    public AttributeValueEntity toEntity(AttributeValueDTO dto) {
        AttributeValueEntity entity = new AttributeValueEntity();
        return getRoleEntity(entity,dto);
    }

    @Override
    public AttributeValueEntity toEntity(AttributeValueEntity entity, AttributeValueDTO dto) {
        return getRoleEntity(entity,dto);
    }

    @NotNull
    private AttributeValueEntity getRoleEntity(AttributeValueEntity entity, AttributeValueDTO dto) {
        entity.setValue(dto.getValue());
        entity.setAttributeEntity(attributeRepos.findById(dto.getAttributeId()).get());
        if( dto.getStatus() != null ) entity.setStatus(dto.getStatus());
        else entity.setStatus(1);
        return entity;
    }
}
