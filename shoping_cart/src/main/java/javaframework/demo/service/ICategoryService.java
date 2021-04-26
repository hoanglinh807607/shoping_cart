package javaframework.demo.service;

import javaframework.demo.dto.CategoryDTO;
import javaframework.demo.dto.CategoryValueDTO;

import java.util.List;

public interface ICategoryService {
    CategoryDTO findOne(Long id);
}
