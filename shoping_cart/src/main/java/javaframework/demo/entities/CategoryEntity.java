package javaframework.demo.entities;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Collection;

@Entity
@Table(name = "category")
@Data
public class CategoryEntity extends BaseEntity{

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "categoryEntity")
    Collection<CategoryValueEntity> categoryValueEntities;
}
