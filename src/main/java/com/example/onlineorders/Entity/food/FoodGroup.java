package com.example.onlineorders.Entity.food;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.NaturalId;

@Data
@Table
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FoodGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(unique = true)
    @NaturalId
    @NotNull(message = "Please enter your name FoodGroup")
    @NotBlank(message = "your name foodGroup must not be blank")
    private String name;
}
