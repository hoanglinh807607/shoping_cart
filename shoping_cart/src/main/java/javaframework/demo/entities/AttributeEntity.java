package javaframework.demo.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Data
@Table(name = "attribute")
public class AttributeEntity extends BaseEntity{

    @Column(name = "name")
    private String name;

    @ManyToMany(mappedBy = "attributeEntities")
    private Collection<ProductEntity> productEntities;

    @OneToMany(mappedBy = "attributeEntity")
    private Collection<AttributeValueEntity> attributeValueEntities;
}
