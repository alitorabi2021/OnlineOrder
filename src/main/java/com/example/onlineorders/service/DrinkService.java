package com.example.onlineorders.service;

import com.example.onlineorders.Entity.drink.Drink;
import com.example.onlineorders.repository.DrinkRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class DrinkService implements IService<Drink>{
    final DrinkRepository drinkRepository;

    public DrinkService(DrinkRepository drinkRepository) {
        this.drinkRepository = drinkRepository;
    }

    @Override
    public String saveOrUpdate(Drink drink) {
        if (drinkRepository.getDrinkById(drink.getId())==null && drinkRepository.getDrinkByName(drink.getName()) == null){
            drinkRepository.save(drink);
            return "save drink in database";
        }else {
            drinkRepository.save(updateDrink(drink));
            return "update drink in database";
        }

    }

    @Override
    public Drink getById(Integer id) {
        return drinkRepository.getDrinkById(id);
    }

    @Override
    public List<Drink> getAll() {
        return drinkRepository.findAll();
    }


    @Override
    public String delete(Drink drink) {
        drinkRepository.delete(updateDrink(drink));
        return "delete the Drink";
    }


    public Drink updateDrink(Drink drink){
        Drink newDrink;
        if (drink.getId()!=null) {
            newDrink = drinkRepository.getDrinkById(drink.getId());
        }else {
            newDrink=drinkRepository.getDrinkByName(drink.getName());
        }
        newDrink.setName(drink.getName());
        newDrink.setPrice(drink.getPrice());
        return newDrink;
    }


}
