package javaframework.demo.repository;

import javaframework.demo.entities.CategoryEntity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepos extends PagingAndSortingRepository<CategoryEntity,Long> {
}
