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
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Table
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Clients {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @NotNull(message = "Please enter your first and last name !")
    @NotBlank(message = "Your first and last name must not be blank")
    private String fullName;
    @Email(message = "this email is not valid please enter true email")
    @NaturalId
    @NotNull(message = "please enter your email !")
    @NotBlank(message = "Your email name must not be blank")
    private String email;
    @NotNull(message = "please enter your phoneNumber !")
    @NotBlank(message = "Your phoneNumber name must not be blank")
    private String phoneNumber;
    @NotNull(message = "please enter your password !")
    @NotBlank(message = "Your password name must not be blank")
    private String password;
    @ManyToOne
    @NotNull
    private RoleClients roleClients;

}
