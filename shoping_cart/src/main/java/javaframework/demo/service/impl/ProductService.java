package javaframework.demo.service.impl;

import javaframework.demo.converter.ProductConverter;
import javaframework.demo.dto.ProductDTO;
import javaframework.demo.entities.ProductEntity;
import javaframework.demo.repository.ProductRepos;
import javaframework.demo.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class ProductService implements IProductService {

    @Autowired
    private ProductRepos productRepos;

    @Autowired
    private ProductConverter productConverter;

    @Override
    public ProductDTO findOne(Long id) {
        return productConverter.toDto(productRepos.findById(id).get());
    }

    @Override
    public ProductDTO save(ProductDTO productDTO) {
        ProductEntity productEntity = new ProductEntity();
        ProductDTO result = new ProductDTO();
        boolean checkInsert = false;
        if (productDTO.getId() != null) {
            ProductEntity entity_old = productRepos.findById(productDTO.getId()).get();
            productEntity = productConverter.toEntity(entity_old, productDTO);
        }
        else {
            productEntity = productConverter.toEntity(productDTO);
            checkInsert = true;
        }
        try {
            result = productConverter.toDto(productRepos.save(productEntity));
        }catch ( Exception e){
            e.printStackTrace();
        }finally {
            if (result.getId() != null) {
                result.setAlert("success");
                if (checkInsert) {
                    result.setMessage("Insert success");
                } else {
                    result.setMessage("Update success");
                }
            } else {
                result.setAlert("danger");
                result.setMessage("No success");
            }
        }
        return result;
    }
}
