package com.example.onlineorders.repository;

import com.example.onlineorders.data.Entity.clients.Clients;
import com.example.onlineorders.data.Entity.clients.RoleClients;
import com.example.onlineorders.data.repository.ClientsRepository;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ClientRepositoryTest {



    @Autowired
    private ClientsRepository clientsRepository;


    @Test
    @Order(1)
    public void test_parameter(){
        List<Clients> clients=clientsRepository.findAll();
        for (Clients client:clients){
            assertNotNull(clientsRepository.getClientsById(client.getId()));

            assertEquals(client,clientsRepository.findByEmail(client.getEmail()).orElseThrow());
            assertNotNull(client.getEmail());
            assertTrue(client.getEmail().length()>=8);

            assertNotNull(client.getRoleClients());

            assertNotNull(client.getPassword());
            assertTrue(client.getPassword().length()>=8);

            assertNotNull(client.getId());

            assertNotEquals(0, client.getId());

            assertNotNull(client.getPhoneNumber());
//            assertTrue(client.getPhoneNumber().length()==11);


            assertNotNull(client.getFullName());
            assertTrue(client.getFullName().length()>=3);


        }
        assertEquals(clientsRepository.findAll(),clients);
    }

    @Test
    @Order(2)
    public void test_save(){
        Clients clients;clients=new Clients();
        clients.setFullName("ali");
        clients.setEmail("torabiali883@gmail.com");
        clients.setPassword("12as12as");
        clients.setPhoneNumber("534564654");
        clients.setRoleClients(RoleClients.builder().id(1).build());
        clientsRepository.save(clients);
    }


    @Test
    @Order(3)
    public void test_delete(){
        Clients clients=clientsRepository.findByEmail("torabiali88@gmail.com").orElseThrow();
        clientsRepository.delete(clients);
    }






}
