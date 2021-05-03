package javaframework.demo.converter;

import javaframework.demo.dto.ProductDTO;
import javaframework.demo.entities.ProductEntity;
import javaframework.demo.repository.CategoryValueRepos;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductConverter extends AbstractConverter<ProductDTO> implements IAbstractConverter<ProductDTO, ProductEntity>{
    @Autowired
    private ImageConverter imageConverter;

    @Autowired
    private CategoryValueRepos categoryRepos;

    @Override
    public ProductDTO toDto(ProductEntity entity) {
        ProductDTO dto = new ProductDTO();
        dto.setName(entity.getName());
        dto.setPrice(entity.getPrice());
        dto.setDiscountPrice(entity.getDiscountPrice());
        dto.setDescription(entity.getDescription());
        dto.setQuantity(entity.getQuantity());
        dto.setContent(entity.getContent());
        dto.setSku(entity.getSku());
        dto.setLove(entity.getLove());
        dto.setCategoryId(entity.getCategoryEntity().getId());
        dto.setCategoryName(entity.getCategoryEntity().getName());
        if( entity.getImageEntities() != null ) {
            entity.getImageEntities().stream().filter(i->!i.getStatus().toString().isEmpty()).forEach(i -> {
                dto.getImageDTOList().add(imageConverter.toDto(i));
            });
        }
        return toDto(dto,entity);
    }

    @Override
    public ProductEntity toEntity(ProductDTO dto) {
        ProductEntity entity = new ProductEntity();
        return getProductEntity(entity,dto);
    }

    @Override
    public ProductEntity toEntity(ProductEntity entity, ProductDTO dto) {
        return getProductEntity(entity,dto);
    }

    @NotNull
    private ProductEntity getProductEntity(ProductEntity entity, ProductDTO dto) {
        entity.setName((String) checkNull(dto.getName(),entity.getName()));
        entity.setPrice((Long) checkNull(dto.getPrice(),entity.getPrice()));
        entity.setDiscountPrice((Long) checkNull(dto.getDiscountPrice(),entity.getDiscountPrice()));
        entity.setDescription((String) checkNull(dto.getDescription(),entity.getDescription()));
        entity.setQuantity((Integer) checkNull(dto.getQuantity(),entity.getQuantity()));
        entity.setContent((String) checkNull(dto.getContent(),entity.getContent()));
        entity.setSku((String) checkNull(dto.getSku(),entity.getSku()));
        entity.setLove((Integer) checkNull(dto.getLove(),entity.getLove()));
        entity.setCategoryEntity( dto.getCategoryId() != null ? categoryRepos.findById(dto.getCategoryId()).get() : entity.getCategoryEntity());
        entity.setImageEntities(entity.getImageEntities());
        entity.setStatus( dto.getStatus() != null ? dto.getStatus() : 1);
        return entity;
    }

    private Object checkNull(Object dto, Object entity){
        if( dto != null ) return dto;
        return entity;
    }
}
