package com.example.onlineorders.controller;

import com.example.onlineorders.Entity.food.Food;
import com.example.onlineorders.service.FoodService;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/food")
public class FoodController {

    final FoodService foodService;

    public FoodController(FoodService foodService) {
        this.foodService = foodService;
    }

    @PostMapping
    public ResponseEntity<String> saveClients(@RequestBody Food food){
        foodService.saveOrUpdate(food);
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
