package com.example.onlineorders;

import com.example.onlineorders.data.repository.ClientsRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class OnlineOrdersApplicationTests {


    @Autowired
    ClientsRepository clientsRepository;

    @Test
    public void fs(){
    clientsRepository.getClientsById(2);
    }

}
