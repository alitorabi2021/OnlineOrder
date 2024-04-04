package com.example.onlineorders.data.Entity.clients;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.NaturalId;

@Table
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Clients {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
