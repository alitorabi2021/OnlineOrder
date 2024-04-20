package com.example.onlineorders.controller;

import com.example.onlineorders.data.Entity.clients.Client;
import com.example.onlineorders.data.Entity.drink.Drink;
import com.example.onlineorders.data.Entity.food.Food;
import com.example.onlineorders.data.Entity.order.Order;
import com.example.onlineorders.service.ClientService;
import com.example.onlineorders.service.OrderService;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    private final OrderService orderService;
    private final ClientService clientService;

    public OrderController(OrderService orderService, ClientService clientService) {
        this.orderService = orderService;
        this.clientService = clientService;
    }



    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String save(@RequestBody Order order){
        order.setOrderTime(new Timestamp(System.currentTimeMillis()));
        long pfood=0;
        long pdrink= 0;

        for (Drink drink:order.getDrinks()){
            pdrink+=drink.getPrice()*drink.getDrinkNumber();
        }
        for (Food food: order.getFoods()){
            pfood+=food.getPrice()*food.getFoodNumber();
        }
        order.setTotalFood(pfood);
        order.setTotalDrink(pdrink);
        order.setTotal(pfood+pdrink);


        Client client = clientService.checkData(order.getClient());
        order.setClient(client);
        return orderService.save(order);
    }



    @GetMapping("/id")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Order getById(@Param("id") Integer id){
        return orderService.getById(id);
    }


    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Order> getAll(){
        return orderService.getAll();
    }



    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public Order update(@RequestBody Order order){
        return orderService.update(order);
    }




    @DeleteMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public String delete(@RequestBody Order order){
        return orderService.delete(order);
    }


}
