package com.example.onlineorders.controller;

import com.example.onlineorders.Entity.clients.Clients;
import com.example.onlineorders.jwt.JwtService;
import com.example.onlineorders.jwt.LoginResponse;
import com.example.onlineorders.security.MyClientsDetails;
import com.example.onlineorders.service.ClientsService;
import jakarta.annotation.PreDestroy;
import jakarta.validation.Valid;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/clients")
@RestController
public class ClientsController {
    private final JwtService jwtService;
    private final   ClientsService clientsService;

    public ClientsController(JwtService jwtService, ClientsService clientsService) {
        this.jwtService = jwtService;
        this.clientsService = clientsService;
    }

    @PostMapping("/login")
    public ResponseEntity<String> authenticate(@RequestBody Clients clients) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || authentication instanceof AnonymousAuthenticationToken) {
            Clients authenticatedUser = clientsService.authenticate(clients);
            String jwtToken = jwtService.generateToken(new MyClientsDetails(authenticatedUser));
            LoginResponse loginResponse = new LoginResponse(jwtToken, jwtService.getExpirationTime());
            return new ResponseEntity<>(loginResponse.getToken(), HttpStatus.OK);
        }else {
            return new ResponseEntity<>("You have been identified",HttpStatus.NON_AUTHORITATIVE_INFORMATION);
        }
    }

    @PostMapping
    public ResponseEntity<String> saveClients(@RequestBody @Valid Clients clients){
        clientsService.save(clients);
        return new ResponseEntity<>("Create the client go to /login",HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Clients>> getAllClients(){
        return new ResponseEntity<>(clientsService.getAll(),HttpStatus.ACCEPTED);
    }
    @GetMapping("/id")
    public ResponseEntity<Clients> getClientById(@Param("id") Integer id){
        return new ResponseEntity<>(clientsService.getById(id),HttpStatus.ACCEPTED);
    }

    @PutMapping
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<Clients> updateClient(Clients clients){
        return new ResponseEntity<>(clientsService.update(clients),HttpStatus.UPGRADE_REQUIRED);
    }


    @DeleteMapping
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<String> deleteClientByEmail(@RequestBody Clients clients){
        return new ResponseEntity<>(clientsService.delete(clients),HttpStatus.ACCEPTED);
    }

}
