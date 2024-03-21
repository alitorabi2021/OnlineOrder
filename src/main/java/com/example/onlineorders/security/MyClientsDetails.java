package com.example.onlineorders.security;

import com.example.onlineorders.Entity.clients.Clients;
import com.example.onlineorders.Entity.clients.RoleClients;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MyClientsDetails implements UserDetails {

    private final Clients clients;

    public MyClientsDetails(Clients clients) {
        this.clients = clients;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<SimpleGrantedAuthority> roleClients=new ArrayList<>();
        roleClients.add(new SimpleGrantedAuthority(clients.getRoleClients().getName()));
        return roleClients;
    }

    @Override
    public String getPassword() {
        return clients.getPassword();
    }

    @Override
    public String getUsername() {
        return clients.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
