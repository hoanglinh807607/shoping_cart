package javaframework.demo.repository;

import javaframework.demo.entities.AttributeEntity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttributeRepos extends PagingAndSortingRepository<AttributeEntity,Long> {
}
