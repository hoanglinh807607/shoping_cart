package javaframework.demo.converter;

import javaframework.demo.dto.CategoryDTO;
import javaframework.demo.entities.CategoryEntity;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;

@Component
public class CategoryConverter extends AbstractConverter<CategoryDTO>{
    public CategoryDTO toDto(CategoryEntity entity) {
        CategoryDTO dto = new CategoryDTO();
        dto.setName(entity.getName());
        return toDto(dto,entity);
    }

    public CategoryEntity toEntity(CategoryDTO dto) {
        CategoryEntity entity = new CategoryEntity();
        return getCategoryEntity(entity,dto);
    }

    public CategoryEntity toEntity(CategoryEntity entity, CategoryDTO dto) {
        return getCategoryEntity(entity,dto);
    }

    @NotNull
    private CategoryEntity getCategoryEntity(CategoryEntity entity, CategoryDTO dto) {
        entity.setName(dto.getName());
        if( dto.getStatus() != null ) entity.setStatus(dto.getStatus());
        else entity.setStatus(0);
        return entity;
    }
}
