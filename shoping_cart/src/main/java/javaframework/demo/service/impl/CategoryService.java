package javaframework.demo.service.impl;

import javaframework.demo.converter.CategoryConverter;
import javaframework.demo.dto.CategoryDTO;
import javaframework.demo.dto.CategoryValueDTO;
import javaframework.demo.repository.CategoryRepos;
import javaframework.demo.service.ICategoryService;
import javaframework.demo.service.ICategoryValueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService implements ICategoryService {

    @Autowired
    private CategoryRepos categoryRepos;

    @Autowired
    private CategoryConverter categoryConverter;

    @Override
    public CategoryDTO findOne(Long id) {
        return categoryConverter.toDto(categoryRepos.findById(id).get());
    }

}
