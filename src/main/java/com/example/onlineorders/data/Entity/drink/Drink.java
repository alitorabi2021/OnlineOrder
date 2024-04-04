package com.example.onlineorders.data.Entity.drink;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.annotations.NaturalId;

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
    @NotNull(message = "Please enter your name drink")
    @Column(unique = true,nullable = false)
    @NaturalId
    @NotBlank(message = "your name drink must not be blank")
    private String name;
    @Column(nullable = false)
    @NotNull(message = "Please enter your price drink")
    private Long price;



}
