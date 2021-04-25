package javaframework.demo.dto;

import lombok.Data;

@Data
public class CategoryDTO extends AbstractDTO<CategoryDTO>{
    private String code;
    private String name;
    private Long parentId;
}
