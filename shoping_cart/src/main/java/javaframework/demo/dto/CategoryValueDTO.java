package javaframework.demo.dto;

import javaframework.demo.entities.ImageEntity;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class CategoryValueDTO extends AbstractDTO<CategoryValueDTO>{
    private String name;
    private Long parentId;
    private List<ImageDTO> imageDTOList = new ArrayList<>();
    private List<ProductDTO> productDTOList = new ArrayList<>();
}
