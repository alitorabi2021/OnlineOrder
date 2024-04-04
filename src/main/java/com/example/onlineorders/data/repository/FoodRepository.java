package com.example.onlineorders.data.repository;

import com.example.onlineorders.data.Entity.food.Food;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodRepository extends JpaRepository<Food,Integer> {
    Food getFoodsById(Integer id);
    Food getFoodsByName(String name);
}
