package com.example.onlineorders.controller;

import com.example.onlineorders.data.Entity.food.Food;
import com.example.onlineorders.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/food")
public class FoodController {

    @Autowired
    private  RestTemplate restTemplate;

    final FoodService foodService;

    @GetMapping("/ali")
    public String getString(){
        Map<String,String> stringMap=new HashMap<>();
        return restTemplate.getForObject("http://localhost:9090/api",String.class,stringMap);
    }
    public FoodController(FoodService foodService) {
        this.foodService = foodService;
    }

    @PostMapping
    public ResponseEntity<String> saveClients(@RequestBody Food food){
        foodService.save(food);
        return new ResponseEntity<>("Create New Foods and save in database",HttpStatus.CREATED);
    }
    @GetMapping
    public List<Food> getAllClients(){
        return foodService.getAll();
    }
    @GetMapping("/id")
    public Food getClientById(@Param("id") Integer id){
        return foodService.getById(id);
    }

    @DeleteMapping
    public ResponseEntity<String> deleteClientById(@RequestBody Food food){
        return new ResponseEntity<>(foodService.delete(food),HttpStatus.ACCEPTED);
    }

}
