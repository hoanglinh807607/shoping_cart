package javaframework.demo.converter;

import javaframework.demo.dto.CategoryValueDTO;
import javaframework.demo.entities.CategoryValueEntity;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CategoryValueConverter extends AbstractConverter<CategoryValueDTO> implements IAbstractConverter<CategoryValueDTO, CategoryValueEntity>{

    @Autowired
    private ImageConverter imageConverter;

    @Autowired
    private ProductConverter productConverter;

    @Override
    public CategoryValueDTO toDto(CategoryValueEntity entity) {
        CategoryValueDTO dto = new CategoryValueDTO();
        dto.setName(entity.getName());
        if( entity.getImageEntities() != null ){
            entity.getImageEntities().stream().forEach(i->{
                dto.getImageDTOList().add(imageConverter.toDto(i));
            });
        }
        if( entity.getProductEntities() != null){
            entity.getProductEntities().stream().filter(p->!p.getStatus().toString().isEmpty())
                    .forEach(p-> dto.getProductDTOList().add(productConverter.toDto(p)));
        }
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
