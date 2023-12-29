package com.example.FirstSecurityApp.controller;

import com.example.FirstSecurityApp.security.PeopleDetails;
import jakarta.persistence.GeneratedValue;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("")
public class PeopleController {

    @GetMapping("/showUserInfo")
    public String showUserInfo(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
       PeopleDetails peopleDetails =  (PeopleDetails)authentication.getPrincipal();

        System.out.println(peopleDetails.getPeople());

        return "Hello World";

    }
}
