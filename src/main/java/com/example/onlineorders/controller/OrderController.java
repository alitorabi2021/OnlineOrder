package com.example.onlineorders.controller;

import com.example.onlineorders.Entity.order.Order;
import com.example.onlineorders.service.OrderService;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@RestController
@RequestMapping("/order")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public ResponseEntity<String> saveOrder(@RequestBody Order order){
        String orderMessage=orderService.saveOrUpdate(order);
        return new ResponseEntity<>(orderMessage, HttpStatus.CREATED);
    }

    @DeleteMapping
    public ResponseEntity<String> deleteOrder(@RequestBody Order order){
        String orderMessage=orderService.delete(order);
        return new ResponseEntity<>(orderMessage, HttpStatus.GONE);
    }
    @GetMapping("/id")
    public Order getOrder(@Param("id") Integer id){
        return orderService.getById(id);
    }
    @GetMapping
    public List<Order> getListOrder(){
        return orderService.getAll();
    }

}
