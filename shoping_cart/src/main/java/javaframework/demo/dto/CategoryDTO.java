package javaframework.demo.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class CategoryDTO extends AbstractDTO<CategoryDTO> {
    private String name;
    private List<CategoryValueDTO> categoryValueDTOS = new ArrayList<>();
}
