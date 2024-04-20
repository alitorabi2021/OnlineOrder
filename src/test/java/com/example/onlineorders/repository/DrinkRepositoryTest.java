package com.example.onlineorders.repository;


import com.example.onlineorders.data.Entity.drink.Drink;
import com.example.onlineorders.data.repository.DrinkRepository;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class DrinkRepositoryTest {

    @Autowired
    private DrinkRepository drinkRepository;

    @Test
    @Order(1)
    public void test_parameter(){
        List<Drink> drinks=drinkRepository.findAll();
        for (Drink drink:drinks){
            assertNotNull(drinkRepository.getDrinkById(drink.getId()));

            assertEquals(drink,drinkRepository.getDrinkByName(drink.getName()));
            assertNotNull(drink.getName());
            assertTrue(drink.getName().length()>=4);


            assertNotNull(drink.getPrice());
            assertTrue(drink.getPrice()>2000);

            assertNotNull(drink.getId());

            assertNotEquals(0, drink.getId());

        }
        assertEquals(drinks,drinkRepository.findAll());
    }


    @Test
    public void test_save(){
        Drink drink=new Drink();
        drink.setName("Soda-Cola");
        drink.setPrice(25000L);
        drinkRepository.save(drink);
    }



    @Test
    public void test_delete(){
        Drink drink=drinkRepository.getDrinkByName("Smoothie");
        drinkRepository.delete(drink);
    }

}
