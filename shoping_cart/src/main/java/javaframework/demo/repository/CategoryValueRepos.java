package javaframework.demo.repository;

import javaframework.demo.entities.CategoryValueEntity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryValueRepos extends PagingAndSortingRepository<CategoryValueEntity,Long> {
}
