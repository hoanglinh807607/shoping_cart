package javaframework.demo.repository;

import javaframework.demo.entities.OrderEntity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepos extends PagingAndSortingRepository<OrderEntity,Long> {
}
