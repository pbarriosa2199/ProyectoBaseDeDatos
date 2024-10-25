package com.basededatos.proyecto.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.basededatos.proyecto.model.entity.Usuarios;
import com.basededatos.proyecto.service.UsuarioService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;




@RestController

public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService; 

    @GetMapping("api/usuarioList")
    public List<Usuarios> getAllUsuarios(){
        return usuarioService.getAllUsuarios();
    }
    
    @GetMapping("api/usuarioById/{idUsuario}")
    public Usuarios getUsuario(@PathVariable("idUsuario") int idUsuario){
        Optional<Usuarios> usuarOptional = usuarioService.findById(idUsuario);
        return usuarOptional.orElse(null);
    }
    
    @PostMapping("api/createUsuario")
    public Usuarios createUsuario(@RequestBody Usuarios usuario){
        return usuarioService.save(usuario);
    }
    
    
    @DeleteMapping(path = "api/deleteUsuario/{id}")
    public void delete(@PathVariable("id") int idUsuario){
        Optional<Usuarios> usuarioOptional = usuarioService.findById(idUsuario);
        usuarioOptional.ifPresent(usuarioService::delete);
    }
}
