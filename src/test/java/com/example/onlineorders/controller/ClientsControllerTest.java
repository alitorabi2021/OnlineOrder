package com.example.onlineorders.controller;

import com.example.onlineorders.data.Entity.clients.Clients;
import com.example.onlineorders.data.Entity.clients.RoleClients;
import com.example.onlineorders.jwt.JwtService;
import com.example.onlineorders.data.repository.ClientsRepository;
import com.example.onlineorders.service.ClientsService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class ClientsControllerTest {
    private static final String URL="/clients";
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;


    @Autowired
    ClientsController clientsController;

    @Autowired
    private JwtService jwtService;

    @MockBean
    private ClientsService clientsService;
    @Autowired
    private ClientsRepository clientsRepository;



    @Test
    public void test_Create() throws Exception {
        Clients clients=Clients.builder()
                .fullName("ali123123")
                .roleClients(RoleClients.builder().id(1).build())
                .email("torabiali885@gmail.com")
                .password("12as12as")
                .phoneNumber("09053317324")
                .build();
        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.post("/clients")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(this.objectMapper.writeValueAsString(clients));
        mockRequest.header("X-Test-Header", "true");
        mockMvc.perform(mockRequest)
                    .andExpect(status().isCreated());
    }

    @Test
    public void test_Update() throws Exception {
      Clients clients=clientsRepository.findByEmail("torabiali887@gmail.com").orElseThrow();
        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.put("/clients")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(this.objectMapper.writeValueAsString(clients));
        mockRequest.header("X-Test-Header", "true");
        mockMvc.perform(mockRequest)
                .andExpect(status().isUpgradeRequired());
    }
    @Test
    public void test_Delete() throws Exception {
        Clients clients=clientsRepository.findByEmail("torabiali887@gmail.com").orElseThrow();
        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.delete("/clients")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(this.objectMapper.writeValueAsString(clients));
        mockRequest.header("X-Test-Header", "true");
        mockMvc.perform(mockRequest)
                .andExpect(status().isAccepted());
    }

    @Test
    public void test_GetAll() throws Exception {
        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.get("/clients")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON);
        mockRequest.header("X-Test-Header", "true");
            mockMvc.perform(mockRequest)
                .andExpect(status().isOk());
    }
    @Test
    public void test_Get_Client() throws Exception {
  Integer id=1;
        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.get("/clients/id")
                .param("id",id.toString())
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON);
        mockRequest.header("X-Test-Header", "true");
        mockMvc.perform(mockRequest)
                .andExpect(status().isAccepted());


    }
    }
