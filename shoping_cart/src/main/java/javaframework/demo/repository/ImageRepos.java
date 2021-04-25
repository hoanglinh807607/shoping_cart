package javaframework.demo.repository;

import javaframework.demo.entities.ImageEntity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageRepos extends PagingAndSortingRepository<ImageEntity,Long> {
}
