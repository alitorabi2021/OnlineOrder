package com.example.onlineorders.security;

import com.example.onlineorders.data.Entity.clients.Client;
import com.example.onlineorders.data.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class ClientsDetailsService implements UserDetailsService {

    @Autowired
    private ClientRepository clientRepository;


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Client client = clientRepository.findByEmail(email).orElseThrow();
        if (client ==null){
            throw new UsernameNotFoundException("Clients is null");
        }
        return new MyClientsDetails(client);
    }
}
