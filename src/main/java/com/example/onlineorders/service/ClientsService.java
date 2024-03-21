package com.example.onlineorders.service;

import com.example.onlineorders.Entity.clients.Clients;
import com.example.onlineorders.Entity.drink.Drink;
import com.example.onlineorders.repository.ClientsRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class ClientsService implements IService<Clients>{

   private final
    BCryptPasswordEncoder bCryptPasswordEncoder;
    private final
    ClientsRepository clientsRepository;
    private final AuthenticationManager authenticationManager;
    public ClientsService(ClientsRepository clientsRepository, BCryptPasswordEncoder bCryptPasswordEncoder, AuthenticationManager authenticationManager) {
        this.clientsRepository = clientsRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.authenticationManager = authenticationManager;
    }
    public Clients authenticate(Clients input) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        input.getEmail(),
                        input.getPassword()
                )
        );
        return clientsRepository.findByEmail(input.getEmail()).orElseThrow();
    }

    @Override
    public String saveOrUpdate(Clients clients) {
        if (clientsRepository.getClientsById(clients.getId())==null
                && clientsRepository.findByEmail(clients.getEmail()).isEmpty()){
            clients.setPassword(bCryptPasswordEncoder.encode(clients.getPassword()));
            clientsRepository.save(clients);
            return "save drink in database";
        }else {
            clientsRepository.save(updateClient(clients));
            return "update drink in database";
        }
    }

    @Override
    public Clients getById(Integer id) {
        return clientsRepository.getClientsById(id);
    }

    @Override
    public List<Clients> getAll() {
        return clientsRepository.findAll();
    }

    @Override
    public String delete(Clients clients) {
         clientsRepository.delete(updateClient(clients));
         return "delete User in database";
    }


    public Clients updateClient(Clients client){
        Clients oldClient;
        if (client.getId()!=null) {
            oldClient=clientsRepository.getClientsById(client.getId());
        }else {
            oldClient=clientsRepository.findByEmail(client.getEmail()).orElseThrow();
        }
        oldClient.setPassword(bCryptPasswordEncoder.encode(client.getPassword()));
        oldClient.setEmail(client.getEmail());
        oldClient.setFullName(client.getFullName());
        oldClient.setPhoneNumber(client.getPhoneNumber());
        return oldClient;
    }
}
