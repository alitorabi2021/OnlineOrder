package com.example.onlineorders.service;

import com.example.onlineorders.data.Entity.order.Order;
import com.example.onlineorders.data.repository.OrderRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class OrderService implements CrudService<Order> {


    final
    OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository){
        this.orderRepository = orderRepository;
    }
    @Override
    public String save(Order order) {
            orderRepository.save(order);
            return "save order in database";
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
    @Override
    public Order update(Order order){
        Order oldOrder=checkData(order);
        oldOrder.setOrderNumber(order.getOrderNumber());
        oldOrder.setFoods(order.getFoods());
        oldOrder.setDrinks(order.getDrinks());
        oldOrder.setClient(order.getClient());
        order.setOrderTime(order.getOrderTime());
        orderRepository.save(oldOrder);
        return oldOrder;
    }


    public Order checkData(Order oldOrder){
        Order order;
        if (oldOrder.getId()!=null) {
            order=orderRepository.getOrderById(oldOrder.getId());
        }else {
            order=orderRepository.getOrderByOrderNumber(oldOrder.getOrderNumber());
        }
        return order;
    }




}
