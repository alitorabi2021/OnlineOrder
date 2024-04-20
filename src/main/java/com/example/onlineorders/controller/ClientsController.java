package com.example.onlineorders.controller;

import com.example.onlineorders.data.Entity.clients.Client;
import com.example.onlineorders.jwt.JwtService;
import com.example.onlineorders.jwt.LoginResponse;
import com.example.onlineorders.security.MyClientsDetails;
import com.example.onlineorders.service.ClientService;
import jakarta.validation.Valid;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RequestMapping(value = "/clients")
@RestController
public class ClientsController {
    private final JwtService jwtService;

    private final ClientService clientService;

    public ClientsController(JwtService jwtService,  ClientService clientService) {
        this.jwtService = jwtService;


        this.clientService = clientService;

    }

    @PostMapping("/login")
    public ResponseEntity<String> authenticate(@RequestBody Client client) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || authentication instanceof AnonymousAuthenticationToken) {
            Client authenticatedUser = clientService.authenticate(client);
            String jwtToken = jwtService.generateToken(new MyClientsDetails(authenticatedUser));
            LoginResponse loginResponse = new LoginResponse(jwtToken, jwtService.getExpirationTime());
            return new ResponseEntity<>(loginResponse.getToken(),HttpStatus.OK);
        } else {
            return new ResponseEntity<>("You have been identified", HttpStatus.NON_AUTHORITATIVE_INFORMATION);
        }
    }


    @PostMapping
    public ResponseEntity<String> save(@RequestBody @Valid Client client){
        client.setEnable(true);
        client.setRegistrationTime(new Date());
        clientService.save(client);
        return new ResponseEntity<>("Create the client go to /login",HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Client>> getAll(){
        return new ResponseEntity<>(clientService.getAll(),HttpStatus.OK);
    }
    @GetMapping("/id")
    public ResponseEntity<Client> getById(@Param("id") Integer id){
        return new ResponseEntity<>(clientService.getById(id), HttpStatus.ACCEPTED);
    }

    @PutMapping
    @PreAuthorize("#{hasRole('ADMIN')}")
    public ResponseEntity<Client> update(Client client){
        return new ResponseEntity<>(clientService.update(client),HttpStatus.OK);
    }


    @DeleteMapping
    @PreAuthorize("#{hasRole('ADMIN')}")
    public ResponseEntity<String> delete(@RequestBody Client client){
    return new ResponseEntity<>(clientService.delete(client),HttpStatus.ACCEPTED);

    }

}
