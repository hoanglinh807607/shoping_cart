package javaframework.demo.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ProductDTO extends AbstractDTO<ProductDTO> {
    private String name;
    private Long price;
    private Long discountPrice;
    private Integer quantity;
    private String description;
    private String content;
    private String sku;
    private Integer love;
    private Long categoryId;
    private String categoryName;
    private List<ImageDTO> imageDTOList = new ArrayList<>();
}
