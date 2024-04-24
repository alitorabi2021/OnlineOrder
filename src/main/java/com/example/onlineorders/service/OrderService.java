package com.example.onlineorders.service;

import com.example.onlineorders.data.Entity.order.Order;
import com.example.onlineorders.data.repository.OrderRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
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
        Order newOrder=checkData(order);
            newOrder.setTotalDrink(order.getTotalDrink());
            newOrder.setTotalFood(order.getTotalFood());
            newOrder.setTotal(order.getTotal());
            newOrder.setOrderTime(new Timestamp(System.currentTimeMillis()));
            newOrder.setClient(order.getClient());
            newOrder.setDrinks(order.getDrinks());
            newOrder.setFoods(order.getFoods());
            newOrder.setOrderNumber(order.getOrderNumber());
            newOrder.setAddress(order.getAddress());

        orderRepository.save(newOrder);
        return newOrder;
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
