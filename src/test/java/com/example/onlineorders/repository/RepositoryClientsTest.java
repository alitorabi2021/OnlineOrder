//package com.example.onlineorders.repository;
//
//import com.example.onlineorders.Entity.clients.Clients;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
//
//import java.util.List;
//import java.util.Optional;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//@DataJpaTest
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
//public class RepositoryClientsTest {
//
//    @Autowired
//    private  ClientsRepository clientsRepository;
//
//
//    @Test
//    public void testFindClients() {
//        List<Clients> clients=clientsRepository.findAll();
//
//        for (Clients client:clients) {
//            assertAll(
//                    () -> assertNotNull(clientsRepository.getClientsById(client.getId())),
//                    () -> assertNotNull(clientsRepository.getClientsByPhoneNumber(client.getPhoneNumber())),
//                    () -> assertNotNull(clientsRepository.findByEmail(client.getEmail())),
//                    () -> assertNotNull(clientsRepository.findById(client.getId()))
//            );
//
//        }
//
//    }
//    @Test
//    public void testGetClientsById() {
//    Clients clients=clientsRepository.getClientsByPhoneNumber("090533173214");
//        Assertions.assertNotNull(clients);
//
//    }
//    @Test
//    void contextLoads() {
//        Clients clients=clientsRepository.getClientsByPhoneNumber("090533173214");
//        Assertions.assertNotNull(clientsRepository.getClientsById(1));
//        Assertions.assertNotNull(clients);
//        System.out.println(clientsRepository.getClientsById(2));
//
//
//    }
//}
