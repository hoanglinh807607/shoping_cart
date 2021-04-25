package javaframework.demo.dto;

import lombok.Data;

@Data
public class RoleDTO extends AbstractDTO<RoleDTO> {
    private String name;
    private String code;
}
