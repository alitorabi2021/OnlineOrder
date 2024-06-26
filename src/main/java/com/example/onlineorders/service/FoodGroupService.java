package com.example.onlineorders.service;

import com.example.onlineorders.data.Entity.food.FoodGroup;
import com.example.onlineorders.data.repository.FoodGroupRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class FoodGroupService implements CrudService<FoodGroup> {

    private final FoodGroupRepository foodGroupRepository;

    public FoodGroupService(FoodGroupRepository foodGroupRepository) {
        this.foodGroupRepository = foodGroupRepository;
    }
    @Override
    public String save(FoodGroup foodGroup) {
            foodGroupRepository.save(foodGroup);
            return "save drink in database";
    }


    @Override
    public FoodGroup getById(Integer id) {
        return foodGroupRepository.getFoodsGroupById(id);
    }

    @Override
    public List<FoodGroup> getAll() {
        return foodGroupRepository.findAll();
    }

    @Override
    public String delete(FoodGroup foodGroup) {
        FoodGroup newFoodGroup =checkData(foodGroup);
        foodGroupRepository.delete(newFoodGroup);
        return "delete FoodsGroup is database";
    }

    @Override
    public FoodGroup update(FoodGroup foodGroup){
        FoodGroup newFoodGroup =checkData(foodGroup);
        newFoodGroup.setName(foodGroup.getName());
        foodGroupRepository.save(newFoodGroup);
        return newFoodGroup;
    }


    public FoodGroup checkData(FoodGroup foodGroup){
        FoodGroup oldFoodGroup;
        if (foodGroup.getId()!=null) {
            oldFoodGroup =foodGroupRepository.getFoodsGroupById(foodGroup.getId());
        }else {
            oldFoodGroup =foodGroupRepository.getFoodsGroupByName(foodGroup.getName());
        }
        return oldFoodGroup;
    }
}


