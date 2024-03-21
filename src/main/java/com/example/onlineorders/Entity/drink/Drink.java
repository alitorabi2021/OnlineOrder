package com.example.onlineorders.Entity.drink;

import com.example.onlineorders.Entity.order.Order;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.annotations.NaturalId;

import java.util.List;

@Table
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class Drink {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull
    @Column(unique = true,nullable = false)
    @NaturalId
    private String name;
    @Column(nullable = false)
    @NotNull
    private Long price;



}
