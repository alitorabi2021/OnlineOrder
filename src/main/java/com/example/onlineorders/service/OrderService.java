package com.example.onlineorders.service;

import com.example.onlineorders.Entity.order.Order;
import com.example.onlineorders.repository.OrderRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class OrderService implements IService<Order>{


    final
    OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository){
        this.orderRepository = orderRepository;
    }
    @Override
    public String saveOrUpdate(Order order) {
        if (orderRepository.getOrderById(order.getId())==null &&
        orderRepository.getOrderByOrderNumber(order.getOrderNumber())==null){
            orderRepository.save(order);
            return "save order in database";
        }else {
            orderRepository.save(updateOrder(order));
            return "update order in database" ;
        }

    }

    @Override
    public Order getById(Integer id) {
        return orderRepository.getOrderById(id);
    }

    @Override
    public List<Order> getAll() {
        return orderRepository.findAll();
    }


    @Override
    public String delete(Order order) {
         orderRepository.delete(checkData(order));
         return "delete order in database";
    }


    public Order checkData(Order foods){
        Order order;
        if (foods.getId()!=null) {
            order=orderRepository.getOrderById(foods.getId());
        }else {
            order=orderRepository.getOrderByOrderNumber(foods.getOrderNumber());
        }
        return order;
    }


    public Order updateOrder(Order order){
        Order oldOrder=checkData(order);
        oldOrder.setOrderNumber(order.getOrderNumber());
        oldOrder.setFoods(order.getFoods());
        oldOrder.setDrinks(order.getDrinks());
        oldOrder.setClients(order.getClients());
        return oldOrder;
    }

}
