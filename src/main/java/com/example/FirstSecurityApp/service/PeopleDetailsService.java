package com.example.FirstSecurityApp.service;

import com.example.FirstSecurityApp.entity.People;
import com.example.FirstSecurityApp.repository.PeopleRepository;
import com.example.FirstSecurityApp.security.PeopleDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PeopleDetailsService implements UserDetailsService {

    @Autowired
    PeopleRepository peopleRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {


      Optional<People> people =  peopleRepository.findByUsername(username);

      if (people.isEmpty()){
          throw  new UsernameNotFoundException("Nu a fost gasit persoana cu asa username: " + username);
      }

      return  new PeopleDetails(people.get());


    }
}
