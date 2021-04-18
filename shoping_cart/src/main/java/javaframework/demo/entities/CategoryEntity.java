package javaframework.demo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Collection;

@Entity
@Table(name = "category")
public class CategoryEntity extends BaseEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "parent_id")
    private String parentId;

    @OneToMany(mappedBy = "categoryEntity")
    Collection<ProductEntity> productEntities;
}
