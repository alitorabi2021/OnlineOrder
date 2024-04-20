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

    final FoodService foodService;

    public FoodController(FoodService foodService) {
        this.foodService = foodService;
    }

    @PostMapping
    public ResponseEntity<String> save(@RequestBody Food food){
        foodService.save(food);
        return new ResponseEntity<>("Create New Foods and save in database",HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Food>> getAll(){
    return new ResponseEntity<>(foodService.getAll(),HttpStatus.OK);
    }

    @GetMapping("/id")
    public ResponseEntity<Food> getClientById(@Param("id") Integer id){
        return new ResponseEntity<>(foodService.getById(id),HttpStatus.ACCEPTED);
    }


    @PutMapping
    public ResponseEntity<Food> update(@RequestBody Food food){
        return new ResponseEntity<>(foodService.update(food),HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<String> delete(@RequestBody Food food){
        return new ResponseEntity<>(foodService.delete(food),HttpStatus.ACCEPTED);
    }


}
