package javaframework.demo.service;

import javaframework.demo.dto.CategoryDTO;

public interface ICategoryService {
    CategoryDTO findOne(Long id);
}
