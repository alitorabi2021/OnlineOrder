package com.example.onlineorders.service;

import com.example.onlineorders.data.Entity.clients.Client;
import com.example.onlineorders.data.repository.ClientRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class ClientService implements CrudService<Client> {

   private final
    BCryptPasswordEncoder bCryptPasswordEncoder;
    private final
    ClientRepository clientRepository;


    private final AuthenticationManager authenticationManager;
    public ClientService(ClientRepository clientRepository, BCryptPasswordEncoder bCryptPasswordEncoder, AuthenticationManager authenticationManager) {
        this.clientRepository = clientRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.authenticationManager = authenticationManager;
    }


    public Client authenticate(Client input) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        input.getEmail(),
                        input.getPassword()
                )
        );
        return clientRepository.findByEmail(input.getEmail()).orElseThrow();
    }

    @Override
    public String save(Client client) {
            client.setPassword(bCryptPasswordEncoder.encode(client.getPassword()));
            clientRepository.save(client);
            return "save drink in database";
    }

    @Override
    public Client getById(Integer id) {
        return clientRepository.getClientsById(id);
    }

    @Override
    public List<Client> getAll() {
        return clientRepository.findAll();
    }

    @Override
    public String delete(Client client) {
        clientRepository.delete(checkData(client));
         return "delete User in database";
    }


    @Override
    public Client update(Client client){
        Client newClient=checkData(client);
        newClient.setPassword(bCryptPasswordEncoder.encode(client.getPassword()));
        newClient.setEmail(client.getEmail());
        newClient.setFullName(client.getFullName());
        newClient.setPhoneNumber(client.getPhoneNumber());
        newClient.setEnable(client.isEnable());
        newClient.setRegistrationTime(client.getRegistrationTime());
        clientRepository.save(newClient);
        return newClient;
    }

    public Client checkData(Client client){
        Client oldClient;
        if (client.getId()!=null) {
            oldClient= clientRepository.getClientsById(client.getId());
        }else if (client.getEmail()!=null){
            oldClient= clientRepository.findByEmail(client.getEmail()).orElseThrow();
        }else if (client.getPhoneNumber()!=null){
            oldClient= clientRepository.getClientsByPhoneNumber(client.getPhoneNumber());
        }else {
            throw new EntityNotFoundException();
        }

        return oldClient;
    }
}
