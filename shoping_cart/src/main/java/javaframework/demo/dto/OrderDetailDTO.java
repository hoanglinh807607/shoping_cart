package javaframework.demo.dto;

import lombok.Data;

@Data
public class OrderDetailDTO extends AbstractDTO<OrderDetailDTO>{
    private final ProductDTO productDTO;
    private Long price;
    private Integer quantity;
    private Long subTotal;
    private Long order_id;

    public OrderDetailDTO(ProductDTO productDTO){
        this.productDTO = productDTO;
        this.quantity = 1;
        this.subTotal = productDTO.getPrice();
        if( productDTO.getDiscountPrice() != null ){
            this.price = productDTO.getDiscountPrice();
        }
        else this.price = productDTO.getPrice();
    }

    public Long getSubTotal() {
        subTotal = price*quantity;
        return subTotal;
    }
}
