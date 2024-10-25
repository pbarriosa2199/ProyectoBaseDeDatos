package com.basededatos.proyecto.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.basededatos.proyecto.model.entity.Usuarios;
import com.basededatos.proyecto.model.repository.UsuariosRepository;

@Service

public class UsuarioService {

    private UsuariosRepository usuarioRepository = null;

    public UsuarioService(UsuariosRepository usuarioRepository){
        
        this.usuarioRepository = usuarioRepository;
    }

    public List<Usuarios> getAllUsuarios(){ 
        return(List<Usuarios>) usuarioRepository.findAll();
    }

    public Optional<Usuarios> findById(Integer id){
        return usuarioRepository.findById(id);
    }

    public Usuarios save(Usuarios id){
        return usuarioRepository.save(id); 
    }

    public Usuarios delete(Usuarios id){
        usuarioRepository.delete(id);
        return id;
    }
    
}
