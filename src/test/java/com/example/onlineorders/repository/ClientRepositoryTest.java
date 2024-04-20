package com.example.onlineorders.repository;

import com.example.onlineorders.data.Entity.clients.Client;
import com.example.onlineorders.data.Entity.clients.RoleClient;
import com.example.onlineorders.data.repository.ClientRepository;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ClientRepositoryTest {



    @Autowired
    private ClientRepository clientRepository;


    @Test
    public void test_parameter(){
        List<Client> clients= clientRepository.findAll();
        for (Client client:clients){
            assertNotNull(clientRepository.getClientsById(client.getId()));

            assertEquals(client, clientRepository.findByEmail(client.getEmail()).orElseThrow());
            assertNotNull(client.getEmail());
            assertTrue(client.getEmail().length()>=8);

            assertNotNull(client.getRoleClient());

            assertNotNull(client.getPassword());
            assertTrue(client.getPassword().length()>=8);

            assertNotNull(client.getId());

            assertNotEquals(0, client.getId());

            assertNotNull(client.getPhoneNumber());
            assertTrue(client.getPhoneNumber().length()==11);


            assertNotNull(client.getFullName());
            assertTrue(client.getFullName().length()>=3);


        }
        assertEquals(clientRepository.findAll(),clients);
    }

    @Test
    public void test_save(){
        Client client;
        client =new Client();
        client.setFullName("ali");
        client.setEmail("torabiali883@gmail.com");
        client.setPassword("12as12as");
        client.setPhoneNumber("534564654");
        client.setRoleClient(RoleClient.builder().id(1).build());
        clientRepository.save(client);
    }


    @Test
    public void test_delete(){
        Client client = clientRepository.findByEmail("torabiali887@gmail.com").orElseThrow();
        clientRepository.delete(client);
    }






}
