package javaframework.demo.dto;

import lombok.Data;

@Data
public class ImageDTO extends AbstractDTO<ImageDTO>{
    private String path;
    private Boolean is_preview;
    private Long foodId;
    private String foodName;
}
