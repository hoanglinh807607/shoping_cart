package javaframework.demo.service;

import javaframework.demo.dto.ProductDTO;

public interface IProductService {
    ProductDTO findOne(Long id);
    ProductDTO save(ProductDTO productDTO);
}
