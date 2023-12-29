package com.example.FirstSecurityApp.controller;

import com.example.FirstSecurityApp.entity.People;
import com.example.FirstSecurityApp.repository.PeopleRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    PeopleRepository peopleRepository;

@PostMapping("/save")
    public ResponseEntity<Object> registration(
            @RequestBody People people){

      return ResponseEntity.status(HttpStatus.OK).body(peopleRepository.save(people));





    }

}
