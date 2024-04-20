package com.example.onlineorders.service;

import com.example.onlineorders.data.Entity.clients.Client;
import com.example.onlineorders.data.repository.ClientRepository;
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
class ClientServiceTest {
    ClientService clientService;

    @Mock
    Client client;

    @Mock
    ClientRepository clientRepository;
    @Mock
    private AuthenticationManager authenticationManager;
    @Mock
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @BeforeEach
    public void init() {
        clientService = new ClientService(clientRepository, bCryptPasswordEncoder, authenticationManager);
        client = new Client();
    }


    @Test
    @Order(1)
    public void test_save() {

        clientService.save(client);
    }


    @Test
    void getById() {
        assertNull(clientService.getById(client.getId()));
    }

    @Test
    void getAll() {
        assertEquals(clientService.getAll(),new ArrayList<>());
    }

    @Test
    void delete() {
        clientService.delete(client);
    }

    @Test
    void update() {
        assertThrows(NoSuchElementException.class,()-> clientService.update(client));
    }

    @Test
    void authenticate() {
        assertThrows(NoSuchElementException.class,()-> clientService.authenticate(client));

    }

}