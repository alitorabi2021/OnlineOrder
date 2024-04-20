package com.example.onlineorders.service;

import com.example.onlineorders.data.Entity.drink.Drink;
import com.example.onlineorders.data.Entity.order.Order;
import com.example.onlineorders.data.repository.DrinkRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class DrinkService implements CrudService<Drink> {
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
        drinkRepository.delete(checkData(drink));
        return "delete the Drink";
    }


    @Override
    public Drink update(Drink drink){
        Drink newDrink=checkData(drink);
        newDrink.setName(drink.getName());
        newDrink.setPrice(drink.getPrice());
        drinkRepository.save(newDrink);
        return newDrink;
    }

    public Drink checkData(Drink oldDrink){
        Drink drink;
        if (oldDrink.getId()!=null) {
            drink=drinkRepository.getDrinkById(oldDrink.getId());
        }else {
            drink=drinkRepository.getDrinkByName(oldDrink.getName());
        }
        return drink;
    }


}
