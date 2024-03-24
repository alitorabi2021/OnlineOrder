package com.example.onlineorders.controller;

import com.example.onlineorders.Entity.food.FoodGroup;
import com.example.onlineorders.service.FoodGroupService;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/foodGroup")
@RestController
public class FoodGroupController {

    final
    FoodGroupService foodGroupService;
    public FoodGroupController(FoodGroupService foodGroupService) {
        this.foodGroupService = foodGroupService;
    }
    @PostMapping
    public ResponseEntity<String> saveFoodGroup(@RequestBody FoodGroup foodGroup){
        return new ResponseEntity<>(foodGroupService.save(foodGroup), HttpStatus.CREATED);
    }

    @GetMapping("/id")
    public FoodGroup getFoodGroup(@Param("id") Integer id){
        return foodGroupService.getById(id);
    }
    @GetMapping
    public List<FoodGroup> getAllFoodGroup(){
        return foodGroupService.getAll();
    }
    @DeleteMapping
    public String deleteFoodGroup(@RequestBody FoodGroup foodGroup){
        return foodGroupService.delete(foodGroup);
    }



}
