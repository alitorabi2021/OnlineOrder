package com.example.onlineorders.controller;

import com.example.onlineorders.data.Entity.drink.Drink;
import com.example.onlineorders.service.DrinkService;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
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
    public ResponseEntity<String> save(@RequestBody Drink drink){
       return new ResponseEntity<>(drinkService.save(drink), HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<Drink>>getAll(){
        return new ResponseEntity<>(drinkService.getAll(),HttpStatus.ACCEPTED);
    }
    @GetMapping("/id")
    public ResponseEntity<Drink> getById(@Param("id") Integer id)  {
       return new ResponseEntity<>(drinkService.getById(id),HttpStatus.OK);
    }
    @PutMapping
    public ResponseEntity<Drink> update(@RequestBody Drink drink){
        return new ResponseEntity<>(drinkService.update(drink),HttpStatus.OK);
    }
    @DeleteMapping
    public ResponseEntity<String> delete(@RequestBody Drink drink){
        return new ResponseEntity<>(drinkService.delete(drink),HttpStatus.ACCEPTED);
    }
}
