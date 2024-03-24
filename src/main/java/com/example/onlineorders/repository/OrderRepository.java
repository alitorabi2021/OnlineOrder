package com.example.onlineorders.repository;

import com.example.onlineorders.Entity.order.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order,Integer> {
    Order getOrderById(Integer id);
    Order getOrderByOrderNumber(Integer orderNumber);
}
