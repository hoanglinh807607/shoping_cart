package javaframework.demo.repository;

import javaframework.demo.entities.AttributeValueEntity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttibuteValueRepos extends PagingAndSortingRepository<AttributeValueEntity,Long> {
}
