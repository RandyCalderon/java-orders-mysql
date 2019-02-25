package com.lambdaschool.orders.repository;

import com.lambdaschool.orders.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
