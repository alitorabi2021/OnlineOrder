//package com.example.onlineorders.service;
//
//import com.example.onlineorders.Entity.clients.Clients;
//import com.example.onlineorders.OnlineOrdersApplication;
//import com.example.onlineorders.repository.ClientsRepository;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.mockito.MockitoAnnotations;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//
//
//@DataJpaTest
//public class ServiceClientsTest {
//
//    @Autowired
//    private ClientsRepository clientsRepository;
//    @Test
//    public void testDeleteClient() {
//    clientsRepository.findByEmail("torabiali88@gmail.com");
//    }
//}