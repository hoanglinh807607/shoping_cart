package javaframework.demo.entities;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "user")
public class UserEntity extends BaseEntity{

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "fullName")
    private String fullName;

    @Column(name = "phone")
    private String phone;

    @Column(name = "address")
    private String address;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Collection<RoleEntity> roleEntities;

    @OneToMany(mappedBy = "userManagerEntity")
    private Collection<OrderEntity> orderEntities_Manager;

    @OneToMany(mappedBy = "userCustomerEntity")
    private Collection<OrderEntity> orderEntities_Customer;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Collection<RoleEntity> getRoleEntities() {
        return roleEntities;
    }

    public void setRoleEntities(Collection<RoleEntity> roleEntities) {
        this.roleEntities = roleEntities;
    }

    public Collection<OrderEntity> getOrderEntities_Manager() {
        return orderEntities_Manager;
    }

    public void setOrderEntities_Manager(Collection<OrderEntity> orderEntities_Manager) {
        this.orderEntities_Manager = orderEntities_Manager;
    }

    public Collection<OrderEntity> getOrderEntities_Customer() {
        return orderEntities_Customer;
    }

    public void setOrderEntities_Customer(Collection<OrderEntity> orderEntities_Customer) {
        this.orderEntities_Customer = orderEntities_Customer;
    }
}
