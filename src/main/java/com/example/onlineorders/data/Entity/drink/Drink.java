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
    @Column(unique = true,nullable = false)
    @NaturalId
    private String name;
    private Long price;
    @Transient
    private Integer drinkNumber;





}
