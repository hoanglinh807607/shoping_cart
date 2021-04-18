package javaframework.demo.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "image")
@Data
public class ImageEntity extends BaseEntity {

    @Column(name = "path")
    private String path;

    @Column(name = "is_preview")
    private String isPreview;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private ProductEntity productEntity;
}
