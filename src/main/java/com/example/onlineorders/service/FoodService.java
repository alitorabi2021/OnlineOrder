package com.example.onlineorders.service;

import com.example.onlineorders.Entity.food.Food;
import com.example.onlineorders.repository.FoodRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class FoodService implements IService<Food>{
    private final FoodRepository foodRepository;

    public FoodService(FoodRepository foodRepository) {
        this.foodRepository = foodRepository;
    }

    @Override
    public Food update(Food food) {
        Food oldFood =checkData(food);
        oldFood.setFoodGroup(food.getFoodGroup());
        oldFood.setName(food.getName());
        oldFood.setPrice(food.getPrice());
        oldFood.setDescription(food.getDescription());
        foodRepository.save(oldFood);
        return oldFood;
    }

    @Override
    public String save(Food food) {
            foodRepository.save(food);
            return "save food in database";
    }

    @Override
    public Food getById(Integer id) {
        return foodRepository.getFoodsById(id);
    }

    @Override
    public List<Food> getAll() {
        return foodRepository.findAll();
    }

    @Override
    public String delete(Food food) {
         foodRepository.delete(checkData(food));
         return "food is delete in database";
    }
    public Food checkData(Food food){
        Food oldFoodGroup;
        if (food.getId()!=null) {
            oldFoodGroup =foodRepository.getFoodsById(food.getId());
        }else {
            oldFoodGroup =foodRepository.getFoodsByName(food.getName());
        }
        return oldFoodGroup;
    }
}