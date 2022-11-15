package me.bouzri.orderservice.repositories;

import me.bouzri.orderservice.entities.Order;
import me.bouzri.orderservice.entities.ProductItem;
import org.aspectj.weaver.ast.Or;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Collection;

@RepositoryRestResource
public interface OrderRepository extends JpaRepository<Order, String> {
    Collection<Order> findAllByCustomerId(Long id);
}
