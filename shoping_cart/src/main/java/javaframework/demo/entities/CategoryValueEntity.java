package javaframework.demo.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "category_value")
@Data
public class CategoryValueEntity extends BaseEntity {

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "parent_id")
    private CategoryEntity categoryEntity;

    @OneToMany(mappedBy = "categoryEntity")
    private Collection<ProductEntity> productEntities;
}
