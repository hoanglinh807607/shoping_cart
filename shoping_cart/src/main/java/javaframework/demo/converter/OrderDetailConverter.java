package javaframework.demo.converter;

import javaframework.demo.dto.OrderDetailDTO;
import javaframework.demo.dto.ProductDTO;
import javaframework.demo.entities.OrderDetailEntity;
import javaframework.demo.repository.OrderRepos;
import javaframework.demo.repository.ProductRepos;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderDetailConverter extends AbstractConverter<OrderDetailDTO> implements IAbstractConverter<OrderDetailDTO, OrderDetailEntity> {
    @Autowired
    private OrderRepos orderRepos;

    @Autowired
    private ProductRepos productRepos;

    @Override
    public OrderDetailDTO toDto(OrderDetailEntity entity) {
        ProductDTO productDTO = new ProductDTO();
        OrderDetailDTO dto = new OrderDetailDTO(productDTO);
        dto.setPrice(entity.getPrice());
        dto.setQuantity(entity.getQuantity());
        dto.setSubTotal(entity.getSubTotal());
        dto.setOrder_id(entity.getOrderEntity().getId());
        return toDto(dto,entity);
    }

    @Override
    public OrderDetailEntity toEntity(OrderDetailDTO dto) {
        OrderDetailEntity entity = new OrderDetailEntity();
        return getOrderDetailEntity(entity,dto);
    }

    @Override
    public OrderDetailEntity toEntity(OrderDetailEntity entity, OrderDetailDTO dto) {
        return getOrderDetailEntity(entity,dto);
    }

    @NotNull
    private OrderDetailEntity getOrderDetailEntity(OrderDetailEntity entity, OrderDetailDTO dto) {
        entity.setPrice(dto.getPrice());
        entity.setQuantity(dto.getQuantity());
        entity.setSubTotal(dto.getSubTotal());
        entity.setOrderEntity(orderRepos.findById(dto.getOrder_id()).get());
        entity.setProductEntity(productRepos.findById(dto.getProductDTO().getId()).get());
        if( dto.getStatus() != null ) entity.setStatus(dto.getStatus());
        else entity.setStatus(0);
        return entity;
    }
}
