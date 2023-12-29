package com.example.FirstSecurityApp.config;

import com.example.FirstSecurityApp.service.PeopleDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
@Configuration
public class SecurityConfig {

    @Autowired
    PeopleDetailsService peopleDetailsService;


    protected  void configure(HttpSecurity httpSecurity) throws  Exception{
        //configuram spring security
        //configuram autorizatiile

        httpSecurity.authorizeRequests()
                .requestMatchers("/auth/save").permitAll()
                .requestMatchers("/api/client/update/*", "/api/delivery/update/*").hasRole("ADMIN")
                .anyRequest().authenticated()
                .and()
                .cors().disable()
                .csrf().disable()
                .httpBasic();


    }

    //Creeaza autentificarea

    protected void configurer(AuthenticationManagerBuilder auth) throws Exception {

        auth.userDetailsService(peopleDetailsService);
    }

    @Bean
    public PasswordEncoder getPasswordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }




}
