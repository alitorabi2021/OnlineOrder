package com.example.onlineorders.repository;

import com.example.onlineorders.Entity.food.Food;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodRepository extends JpaRepository<Food,Integer> {
    Food getFoodsById(Integer id);
    Food getFoodsByName(String name);
}
