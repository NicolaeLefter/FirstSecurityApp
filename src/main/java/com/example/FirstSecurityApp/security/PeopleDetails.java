package com.example.FirstSecurityApp.security;

import com.example.FirstSecurityApp.entity.People;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public class PeopleDetails implements UserDetails {
    @Autowired
    People people;

    public PeopleDetails(People people) {
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return this.people.getPassword();
    }

    @Override
    public String getUsername() {
        return this.people.getUsername();
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
    //Trebuie sa intoarca datele persoanei autentificate
    public People getPeople(){
        return this.people;
    }
}
