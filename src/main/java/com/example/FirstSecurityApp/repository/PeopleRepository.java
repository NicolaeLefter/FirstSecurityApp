package com.example.FirstSecurityApp.repository;

import com.example.FirstSecurityApp.entity.People;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PeopleRepository extends JpaRepository<People, Integer> {


    Optional<People> findByUsername(String username);
}
