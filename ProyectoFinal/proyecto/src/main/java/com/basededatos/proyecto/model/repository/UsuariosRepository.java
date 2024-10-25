package com.basededatos.proyecto.model.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.basededatos.proyecto.model.entity.Usuarios;


public interface UsuariosRepository extends CrudRepository<Usuarios, Integer> {

    

}
