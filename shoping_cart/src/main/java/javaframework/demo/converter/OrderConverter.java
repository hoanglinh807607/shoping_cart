package javaframework.demo.converter;

import javaframework.demo.dto.OrderDTO;
import javaframework.demo.entities.OrderEntity;
import javaframework.demo.repository.UserRepos;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderConverter extends AbstractConverter<OrderDTO> implements IAbstractConverter<OrderDTO, OrderEntity>{
    @Autowired
    private UserRepos userRepos;

    @Override
    public OrderDTO toDto(OrderEntity entity) {
        OrderDTO dto = new OrderDTO();
        dto.setCode(entity.getCode());
        dto.setTotal(entity.getTotal());
        dto.setOrderStatus(entity.getOrderStatus());
        dto.setUser_customer_id(entity.getUserCustomerEntity().getId());
        dto.setUser_customer_email(entity.getUserCustomerEntity().getEmail());
        dto.setUser_manager_id(entity.getUserManagerEntity().getId());
        dto.setUser_manager_email(entity.getUserManagerEntity().getEmail());
        return toDto(dto,entity);
    }

    @Override
    public OrderEntity toEntity(OrderDTO dto) {
        OrderEntity entity = new OrderEntity();
        return getOrderEntity(entity,dto);
    }

    @Override
    public OrderEntity toEntity(OrderEntity entity, OrderDTO dto) {
        return getOrderEntity(entity,dto);
    }

    @NotNull
    private OrderEntity getOrderEntity(OrderEntity entity, OrderDTO dto) {
        entity.setCode(dto.getCode());
        entity.setTotal(dto.getTotal());
        entity.setOrderStatus(dto.getOrderStatus());
        entity.setUserCustomerEntity(userRepos.findById(dto.getUser_customer_id()).get());
        entity.setUserManagerEntity(userRepos.findById(dto.getUser_manager_id()).get());
        if( dto.getStatus() != null ) entity.setStatus(dto.getStatus());
        else entity.setStatus(0);
        return entity;
    }
}
