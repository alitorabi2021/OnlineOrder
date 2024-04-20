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

import java.util.Date;

@Table
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    private String fullName;


    @Email(message = "this email is not valid please enter true email")
    @NaturalId
    @NotNull(message = "please enter your email !")
    @NotBlank(message = "Your email name must not be blank")
    private String email;

    private String phoneNumber;


    private String password;


    @ManyToOne
    private RoleClient roleClient;

    private boolean isEnable;

    private Date registrationTime;


}
