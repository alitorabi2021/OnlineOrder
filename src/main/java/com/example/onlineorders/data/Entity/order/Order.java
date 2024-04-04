package com.example.onlineorders.data.Entity.order;

import com.example.onlineorders.data.Entity.clients.Clients;
import com.example.onlineorders.data.Entity.drink.Drink;
import com.example.onlineorders.data.Entity.food.Food;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.NaturalId;

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
    @NotNull
    private Integer orderNumber;
    @OneToMany
    private List<Food> foods;
    @OneToMany
    private List<Drink> drinks;
    @ManyToOne
    private Clients clients;
    @Embedded
    @NotNull
    private Address address;
 }
