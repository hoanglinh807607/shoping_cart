package javaframework.demo.repository;

import javaframework.demo.entities.UserEntity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepos extends PagingAndSortingRepository<UserEntity, Long> {
}
