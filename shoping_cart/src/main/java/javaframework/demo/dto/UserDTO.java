package javaframework.demo.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class UserDTO extends AbstractDTO<UserDTO>{
    private String email;
    private String password;
    private String phone;
    private String address;
    private String fullName;
    private List<Long> roleId = new ArrayList<>();
    private List<String> roleName = new ArrayList<>();
}
