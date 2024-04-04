package com.example.onlineorders.data.repository;

import com.example.onlineorders.data.Entity.food.FoodGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodGroupRepository extends JpaRepository<FoodGroup,Integer> {

    FoodGroup getFoodsGroupById(Integer id);

    FoodGroup getFoodsGroupByName(String name);
}
