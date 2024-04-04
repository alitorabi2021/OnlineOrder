package com.example.onlineorders.data.repository;

import com.example.onlineorders.data.Entity.drink.Drink;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DrinkRepository extends JpaRepository<Drink,Integer> {
    Drink getDrinkById(Integer id);

    Drink getDrinkByName(String name);
}
