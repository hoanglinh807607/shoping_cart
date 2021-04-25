package javaframework.demo.repository;

import javaframework.demo.entities.OrderDetailEntity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDetailRepos extends PagingAndSortingRepository<OrderDetailEntity,Long> {
}
