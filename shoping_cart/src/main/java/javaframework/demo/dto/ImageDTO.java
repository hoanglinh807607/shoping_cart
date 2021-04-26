package javaframework.demo.dto;

import lombok.Data;

@Data
public class ImageDTO extends AbstractDTO<ImageDTO>{
    private String path;
    private Integer is_preview;
    private Long productId;
    private String productName;
    private Long categoryValueId;
    private String categoryValueName;
}
