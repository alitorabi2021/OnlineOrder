package com.example.onlineorders.service;

import com.example.onlineorders.data.Entity.clients.Clients;
import com.example.onlineorders.data.repository.ClientsRepository;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
@ExtendWith(SpringExtension.class)
class ClientsServiceTest {
    ClientsService clientsService;

    @Mock
    Clients clients;

    @Mock
    ClientsRepository clientsRepository;
    @Mock
    private AuthenticationManager authenticationManager;
    @Mock
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @BeforeEach
    public void init() {
        clientsService = new ClientsService(clientsRepository, bCryptPasswordEncoder, authenticationManager);
        clients = new Clients();
    }


    @Test
    @Order(1)
    public void test_save() {

        clientsService.save(clients);
    }


    @Test
    void getById() {
        assertNull(clientsService.getById(clients.getId()));
    }

    @Test
    void getAll() {
        assertEquals(clientsService.getAll(),new ArrayList<>());
    }

    @Test
    void delete() {
        clientsService.delete(clients);
    }

    @Test
    void update() {
        assertThrows(NoSuchElementException.class,()->clientsService.update(clients));
    }

    @Test
    void authenticate() {
        assertThrows(NoSuchElementException.class,()->clientsService.authenticate(clients));

    }

}