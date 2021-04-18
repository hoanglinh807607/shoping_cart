package javaframework.demo.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "attribute_value")
public class AttributeValueEntity extends BaseEntity{

    @Column(name = "value")
    private String path;

    @ManyToOne
    @JoinColumn(name = "attribute_id")
    private AttributeEntity attributeEntity;
}
