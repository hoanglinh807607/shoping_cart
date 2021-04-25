package javaframework.demo.converter;

import javaframework.demo.dto.UserDTO;
import javaframework.demo.entities.UserEntity;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;

@Component
public class UserConverter extends AbstractConverter<UserDTO> implements IAbstractConverter<UserDTO, UserEntity> {

    @Override
    public UserDTO toDto(UserEntity entity) {
        UserDTO dto = new UserDTO();
        dto.setEmail(entity.getEmail());
        dto.setPassword(entity.getPassword());
        dto.setFullName(entity.getFullName());
        dto.setPhone(entity.getPhone());
        dto.setAddress(entity.getAddress());
        entity.getRoleEntities().stream().forEach(e->{
            dto.getRoleId().add(e.getId());
            dto.getRoleName().add(e.getName());
        });
        return toDto(dto,entity);
    }

    @Override
    public UserEntity toEntity(UserDTO dto) {
        UserEntity result = new UserEntity();
        return getUserEntity(result, dto);
    }

    @Override
    public UserEntity toEntity(UserEntity entity, UserDTO dto) {
        return getUserEntity(entity, dto);
    }

    @NotNull
    private UserEntity getUserEntity(UserEntity entity, UserDTO dto) {
        entity.setEmail(dto.getEmail());
        entity.setPassword(dto.getPassword());
        entity.setFullName(dto.getFullName());
        entity.setPhone(dto.getPhone());
        entity.setAddress(dto.getAddress());
        if( dto.getStatus() != null ) entity.setStatus(dto.getStatus());
        else entity.setStatus(1);
        return entity;
    }

}
