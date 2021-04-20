package javaframework.demo.converter;

import javaframework.demo.dto.RoleDTO;
import javaframework.demo.entities.RoleEntity;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;

@Component
public class RoleConverter {

    public RoleDTO toDto(RoleEntity entity) {
        RoleDTO dto = new RoleDTO();
        dto.setCode(entity.getCode());
        dto.setName(entity.getName());
        return dto;
    }

    public RoleEntity toEntity(RoleDTO dto) {
        RoleEntity entity = new RoleEntity();
        return getRoleEntity(entity,dto);
    }

    public RoleEntity toEntity(RoleEntity entity, RoleDTO dto) {
        return getRoleEntity(entity,dto);
    }

    @NotNull
    private RoleEntity getRoleEntity(RoleEntity entity, RoleDTO dto) {
        entity.setCode(dto.getCode());
        entity.setName(dto.getName());
        return entity;
    }

}
