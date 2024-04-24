package com.example.onlineorders.data.Entity.order;

import com.example.onlineorders.data.Entity.clients.Client;
import com.example.onlineorders.data.Entity.drink.Drink;
import com.example.onlineorders.data.Entity.food.Food;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.NaturalId;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Table(name = "orders")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "order_number")
    @NaturalId
    private Integer orderNumber;
    @ManyToMany
    private List<Food> foods;
    @ManyToMany
    private List<Drink> drinks;
    @ManyToOne
    private Client client;
    @Embedded
    private Address address;
    private Timestamp orderTime;
    private Long total;
    private Long totalFood;
    private Long totalDrink;


 }
