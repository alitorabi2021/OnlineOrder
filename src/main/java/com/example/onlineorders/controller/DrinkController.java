package com.example.onlineorders.controller;

import com.example.onlineorders.Entity.drink.Drink;
import com.example.onlineorders.service.DrinkService;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/drink")
@RestController
public class DrinkController {
    final DrinkService drinkService;

    public DrinkController(DrinkService drinkService) {
        this.drinkService = drinkService;
    }

    @PostMapping
    public ResponseEntity<String> saveDrink(@RequestBody Drink drink){
       return new ResponseEntity<>(drinkService.saveOrUpdate(drink), HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<Drink>>getAllDrink(){
        return new ResponseEntity<>(drinkService.getAll(),HttpStatus.ACCEPTED);
    }
    @GetMapping("/id")
    public Drink getDrink(@Param("id") Integer id)  {
       return drinkService.getById(id);
    }
    @PutMapping
    public Drink updateDrink(@RequestBody Drink drink){
        return drinkService.updateDrink(drink);
    }
    @DeleteMapping
    public String deleteDrink(@RequestBody Drink drink){
        return drinkService.delete(drink);
    }
}
