package javaframework.demo.converter;

import javaframework.demo.dto.ProductDTO;
import javaframework.demo.entities.ProductEntity;
import javaframework.demo.repository.CategoryRepos;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductConverter extends AbstractConverter<ProductDTO> {
    @Autowired
    private ImageConverter imageConverter;

    @Autowired
    private CategoryRepos categoryRepos;

    public ProductDTO toDto(ProductEntity entity) {
        ProductDTO dto = new ProductDTO();
        dto.setName(entity.getName());
        dto.setPrice(entity.getPrice());
        dto.setDiscountPrice(entity.getDiscountPrice());
        dto.setDescription(entity.getDescription());
        dto.setQuantity(entity.getQuantity());
        dto.setContent(entity.getContent());
        dto.setSku(entity.getSku());
        dto.setCategoryId(entity.getCategoryEntity().getId());
        dto.setCategoryName(entity.getCategoryEntity().getName());
        if( entity.getImageEntities() != null ) {
            entity.getImageEntities().stream().forEach(i -> {
                dto.getImageDTOS().add(imageConverter.toDto(i));
            });
        }
        return toDto(dto,entity);
    }

    public ProductEntity toEntity(ProductDTO dto) {
        ProductEntity entity = new ProductEntity();
        return getProductEntity(entity,dto);
    }

    public ProductEntity toEntity(ProductEntity entity, ProductDTO dto) {
        return getProductEntity(entity,dto);
    }

    @NotNull
    private ProductEntity getProductEntity(ProductEntity entity, ProductDTO dto) {
        entity.setName(dto.getName());
        entity.setPrice(dto.getPrice());
        if( dto.getDiscountPrice() != null ) entity.setDiscountPrice(dto.getDiscountPrice());
        else entity.setDiscountPrice(0l);
        entity.setDescription(dto.getDescription());
        entity.setQuantity(dto.getQuantity());
        entity.setContent(dto.getContent());
        entity.setSku(dto.getSku());
        entity.setCategoryEntity(categoryRepos.findById(dto.getCategoryId()).get());
        if( dto.getStatus() != null ) entity.setStatus(dto.getStatus());
        else entity.setStatus(0);
        return entity;
    }
}
