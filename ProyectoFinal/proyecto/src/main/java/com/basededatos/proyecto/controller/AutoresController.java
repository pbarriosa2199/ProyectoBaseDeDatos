package com.basededatos.proyecto.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.basededatos.proyecto.model.entity.Autores;
import com.basededatos.proyecto.service.AutoresService;

@RestController
public class AutoresController {
	@Autowired
	private AutoresService autoresService;

	@GetMapping("api/autoresList")
	public List<Autores> getAllAutores(){
		return autoresService.getAllAutores();
	}

	@GetMapping("api/autorById/{idAutor}")
	public Autores getAutoresById(@PathVariable("idAutor") int idAutor){
		Optional<Autores> autoresOptional = autoresService.findById(idAutor);
		return autoresOptional.orElse(null);
	}

	@PostMapping("api/createAutores")
	public Autores createAutores(@RequestBody Autores autor){
		return autoresService.save(autor);
	}

	@PutMapping(path = "api/updateAutores")
	public Autores updateAutores(@RequestBody Autores updtAutores){
		int tmpID = updtAutores.getIdAutor();
		if(autoresService.findById(tmpID).isPresent()){
			return autoresService.save(updtAutores);
		}
		else{
			return null;
		}
	}

	@DeleteMapping(path = "api/deleteAutores/{id}")
	public void delete(@PathVariable("id") int idAutores){
		Optional<Autores> autorOptional = autoresService.findById(idAutores);
			autorOptional.ifPresent(autoresService::delete);
		}
	
}