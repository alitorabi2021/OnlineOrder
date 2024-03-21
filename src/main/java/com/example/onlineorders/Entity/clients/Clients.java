package com.example.onlineorders.Entity.clients;


import com.example.onlineorders.Entity.order.Order;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.NaturalId;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Table
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Clients {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String fullName;
    @NotNull
    @Column(unique = true)
    @NaturalId
    @NotBlank
    @Email
    private String email;
    private String phoneNumber;
    @NotNull
    private String password;
    @ManyToOne
    private RoleClients roleClients;

}
