package com.example.onlineorders.controller;

import com.example.onlineorders.data.Entity.order.Order;
import com.example.onlineorders.service.OrderService;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public ResponseEntity<String> saveOrder(@RequestBody Order order){
        String orderMessage=orderService.save(order);
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
