package com.example.onlineorders.data.repository;

import com.example.onlineorders.data.Entity.clients.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<Client,Integer> {

    Optional<Client> findByEmail(String email);

    Client getClientsById(Integer id);
    Client getClientsByPhoneNumber(String phoneNumber);
}
