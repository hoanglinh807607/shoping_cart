package javaframework.demo.repository;

import javaframework.demo.entities.RoleEntity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepos extends PagingAndSortingRepository<RoleEntity,Long> {
}
