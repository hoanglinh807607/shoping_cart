package javaframework.demo.repository;

import javaframework.demo.entities.ImageEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ImageRepos extends PagingAndSortingRepository<ImageEntity,Long> {

}
