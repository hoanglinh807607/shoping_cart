package javaframework.demo.converter;

import javaframework.demo.dto.CategoryValueDTO;
import javaframework.demo.entities.CategoryValueEntity;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;

@Component
public class CategoryValueConverter extends AbstractConverter<CategoryValueDTO> implements IAbstractConverter<CategoryValueDTO, CategoryValueEntity>{

    @Override
    public CategoryValueDTO toDto(CategoryValueEntity entity) {
        CategoryValueDTO dto = new CategoryValueDTO();
        dto.setName(entity.getName());
        return toDto(dto,entity);
    }

    @Override
    public CategoryValueEntity toEntity(CategoryValueDTO dto) {
        CategoryValueEntity entity = new CategoryValueEntity();
        return getCategoryEntity(entity,dto);
    }

    @Override
    public CategoryValueEntity toEntity(CategoryValueEntity entity, CategoryValueDTO dto) {
        return getCategoryEntity(entity,dto);
    }

    @NotNull
    private CategoryValueEntity getCategoryEntity(CategoryValueEntity entity, CategoryValueDTO dto) {
        entity.setName(dto.getName());
        if( dto.getStatus() != null ) entity.setStatus(dto.getStatus());
        else entity.setStatus(1);
        return entity;
    }
}
