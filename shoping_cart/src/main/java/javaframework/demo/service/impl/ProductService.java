package javaframework.demo.service.impl;

import javaframework.demo.converter.ProductConverter;
import javaframework.demo.dto.ProductDTO;
import javaframework.demo.repository.ProductRepos;
import javaframework.demo.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
