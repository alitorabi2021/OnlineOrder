package com.example.onlineorders.repository;

import com.example.onlineorders.Entity.drink.Drink;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.Optional;

@Repository
public interface DrinkRepository extends JpaRepository<Drink,Integer> {
    Drink getDrinkById(Integer id);

    Drink getDrinkByName(String name);
}
