package com.example.onlineorders.controller;

import com.example.onlineorders.data.Entity.food.FoodGroup;
import com.example.onlineorders.service.FoodGroupService;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/foodGroup")
@RestController
public class FoodGroupController {

    final FoodGroupService foodGroupService;
    public FoodGroupController(FoodGroupService foodGroupService) {
        this.foodGroupService = foodGroupService;
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String save(@RequestBody FoodGroup foodGroup){
        return foodGroupService.save(foodGroup);
    }

    @GetMapping("/id")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public FoodGroup getById(@Param("id") Integer id){
        return foodGroupService.getById(id);
    }
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<FoodGroup> getAll(){
        return foodGroupService.getAll();
    }

    @PutMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    public FoodGroup update(FoodGroup foodGroup){
    return foodGroupService.update(foodGroup);
    }
    @DeleteMapping
    @ResponseStatus(HttpStatus.OK)
    public String delete(@RequestBody FoodGroup foodGroup){
        return foodGroupService.delete(foodGroup);
    }



}
