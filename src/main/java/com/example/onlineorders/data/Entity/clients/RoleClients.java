package com.example.onlineorders.data.Entity.clients;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Table
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class RoleClients {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull(message = "error! this role is null")
    private String name;
}
