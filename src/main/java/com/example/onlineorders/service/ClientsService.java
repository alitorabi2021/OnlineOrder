package com.example.onlineorders.service;

import com.example.onlineorders.data.Entity.clients.Clients;
import com.example.onlineorders.data.repository.ClientsRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
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
    public String save(Clients clients) {
            clients.setPassword(bCryptPasswordEncoder.encode(clients.getPassword()));
            clientsRepository.save(clients);
            return "save drink in database";
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
    public String delete(Clients client) {
        Clients deleteClient;
        if (client.getId()!=null) {
            deleteClient=clientsRepository.getClientsById(client.getId());
        }else {
            deleteClient=clientsRepository.findByEmail(client.getEmail()).orElseThrow();
        }
        clientsRepository.delete(deleteClient);
         return "delete User in database";
    }


    @Override
    public Clients update(Clients client){
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
        clientsRepository.save(oldClient);
        return oldClient;
    }
}
