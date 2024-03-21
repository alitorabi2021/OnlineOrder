package com.example.onlineorders.repository;

import com.example.onlineorders.Entity.clients.Clients;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientsRepository extends JpaRepository<Clients,Integer> {

    Optional<Clients> findByEmail(String email);
    Clients getClientsById(Integer id);
    Clients getClientsByPhoneNumber(String phoneNumber);
}
