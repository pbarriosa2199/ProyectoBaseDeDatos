package com.basededatos.proyecto.model.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.basededatos.proyecto.model.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{
    Optional<User> findByUsername(String username);
    
}