package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Registration;

public interface RegistrationRepo extends JpaRepository<Registration, Integer>{

}