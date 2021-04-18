package javaframework.demo.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name="product")
@Data
public class ProductEntity extends BaseEntity{

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private String price;

    @Column(name = "quantity")
    private String quantity;

    @Column(name = "description")
    private String description;

    @Column(name = "content")
    private String content;

    @Column(name = "discount_price")
    private String discountPrice;

    @Column(name = "sku")
    private String sku;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private CategoryEntity categoryEntity;

    @OneToMany(mappedBy = "productEntity")
    private Collection<ImageEntity> imageEntities;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "attribute_product",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "attribute_id"))
    private Collection<AttributeEntity> attributeEntities;

}
