package com.example.onlineorders.service;

import com.example.onlineorders.data.Entity.drink.Drink;
import com.example.onlineorders.data.repository.DrinkRepository;
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
    public String save(Drink drink) {
            drinkRepository.save(drink);
            return "save drink in database";
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
        drinkRepository.delete(drink);
        return "delete the Drink";
    }


    @Override
    public Drink update(Drink drink){
        Drink newDrink;
        if (drink.getId()!=null) {
            newDrink = drinkRepository.getDrinkById(drink.getId());
        }else {
            newDrink=drinkRepository.getDrinkByName(drink.getName());
        }
        newDrink.setName(drink.getName());
        newDrink.setPrice(drink.getPrice());
        drinkRepository.save(newDrink);
        return newDrink;
    }


}
