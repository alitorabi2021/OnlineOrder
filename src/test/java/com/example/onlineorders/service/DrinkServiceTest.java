package com.example.onlineorders.service;

import com.example.onlineorders.data.Entity.drink.Drink;
import com.example.onlineorders.data.repository.DrinkRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(MockitoExtension.class)
@ExtendWith(SpringExtension.class)
class DrinkServiceTest {


    @Mock
    private Drink drink;

    @Mock
    private DrinkRepository drinkRepository;

    DrinkService drinkService;

    @BeforeEach
    public void init(){
        drink=new Drink();
        drinkService =new DrinkService(drinkRepository);
    }



    @Test
    void save() {
       assertNotNull(drinkService.save(drink));
    }

    @Test
    void getById() {

        assertNull(drinkService.getById(4));
    }

    @Test
    void getAll() {
        assertNotNull(drinkService.getAll());
    }

    @Test
    void delete() {

        drinkService.delete(drink);
    }

    @Test
    void update() {
        assertThrows(NullPointerException.class,()->drinkService.update(drink));

    }

    @Test
    void checkData() {
        assertNull(drinkService.checkData(drink));

    }
}