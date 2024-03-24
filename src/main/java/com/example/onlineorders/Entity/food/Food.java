package com.example.onlineorders.Entity.food;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.NaturalId;

@Table
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Food {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(unique = true,nullable = false)
    @NotNull(message = "Please enter your name food")
    @NaturalId
    @NotBlank(message = "your name food must not be blank")
    private String name;
    @ManyToOne
    private FoodGroup foodGroup;
    private Long price;
    private String description;



}
