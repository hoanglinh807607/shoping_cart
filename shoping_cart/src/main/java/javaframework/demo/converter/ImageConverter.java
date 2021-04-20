package javaframework.demo.converter;

import javaframework.demo.dto.ImageDTO;
import javaframework.demo.entities.ImageEntity;
import javaframework.demo.repository.ProductRepos;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ImageConverter extends AbstractConverter<ImageDTO>{
    @Autowired
    private ProductRepos productRepos;

    public ImageDTO toDto(ImageEntity entity) {
        ImageDTO dto = new ImageDTO();
        dto.setPath(entity.getPath());
        dto.setIs_preview(entity.getIsPreview());
        dto.setFoodId(entity.getProductEntity().getId());
        dto.setFoodName(entity.getProductEntity().getName());
        return toDto(dto,entity);
    }

    public ImageEntity toEntity(ImageDTO dto) {
        ImageEntity entity = new ImageEntity();
        return getImageEntity(entity,dto);
    }

    public ImageEntity toEntity(ImageEntity entity, ImageDTO dto) {
        return getImageEntity(entity,dto);
    }

    @NotNull
    private ImageEntity getImageEntity(ImageEntity entity, ImageDTO dto) {
        if( dto.getPath() != null ) entity.setPath(dto.getPath());
        entity.setIsPreview(dto.getIs_preview());
        entity.setProductEntity(productRepos.findById(dto.getFoodId()).get());
        entity.setCreatedDate(dto.getCreatedDate());
        entity.setCreatedBy(dto.getCreatedBy());
        entity.setModifiedDate(dto.getModifiedDate());
        entity.setModifiedBy(dto.getModifiedBy());
        if( dto.getStatus() != null ) entity.setStatus(dto.getStatus());
        else entity.setStatus(0);
        return entity;
    }
}
