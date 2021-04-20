package javaframework.demo.repository;

import javaframework.demo.entities.ProductEntity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepos extends PagingAndSortingRepository<ProductEntity,Long> {
}
