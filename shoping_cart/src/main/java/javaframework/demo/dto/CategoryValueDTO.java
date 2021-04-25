package javaframework.demo.dto;

import lombok.Data;

@Data
public class CategoryValueDTO extends AbstractDTO<CategoryValueDTO>{
    private String code;
    private String name;
    private Long parentId;
}
