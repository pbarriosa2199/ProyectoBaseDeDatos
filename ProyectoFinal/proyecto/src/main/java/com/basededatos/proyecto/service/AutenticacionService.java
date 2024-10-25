package com.basededatos.proyecto.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.basededatos.proyecto.model.entity.User;
import com.basededatos.proyecto.model.repository.UserRepository;


@Service

public class AutenticacionService {

    @Autowired
    private UserRepository userRepository;

    public boolean validarCredenciales(String username, String password) {
        Optional<User> usuarioOpt = userRepository.findByUsername(username);

        if(usuarioOpt.isPresent()){
            User user = usuarioOpt.get();
            return user.getPassword().equals(password);
        }
        return false;
    }
    
    
}
