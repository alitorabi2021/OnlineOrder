package com.example.onlineorders.security;

import com.example.onlineorders.data.Entity.clients.Clients;
import com.example.onlineorders.data.repository.ClientsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class ClientsDetailsService implements UserDetailsService {

    @Autowired
    private ClientsRepository clientsRepository;


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Clients clients=clientsRepository.findByEmail(email).orElseThrow();
        if (clients==null){
            throw new UsernameNotFoundException("Clients is null");
        }
        return new MyClientsDetails(clients);
    }
}
