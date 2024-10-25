package com.basededatos.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.basededatos.proyecto.service.AutenticacionService;
import org.springframework.web.bind.annotation.PostMapping;


@RestController

public class LoginController {

    @Autowired
    private AutenticacionService utenticacionService;

    @PostMapping("api/Login")
    public ResponseEntity<String> login(@RequestParam String username, @RequestParam String password){
        boolean isValid = utenticacionService.validarCredenciales(username, password);

        if (isValid){
            return ResponseEntity.ok("Login exitoso");
        }else{
            return ResponseEntity.status(401).body("Credenciales invalidas");
        }
    }
}
