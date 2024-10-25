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

import com.basededatos.proyecto.model.entity.Libros;
import com.basededatos.proyecto.service.LibrosService;

@RestController
public class LibrosController {
	@Autowired
	private LibrosService librosService;

	@GetMapping("api/librosList")
	public List<Libros> getAllLibros(){
		return librosService.getAllLibros();
	}

	@GetMapping("api/libroById/{idLibro}")
	public Libros getLibrosById(@PathVariable("idLibro") int idLibro){
		Optional<Libros> librosOptional = librosService.findById(idLibro);
		return librosOptional.orElse(null);
	}

	@PostMapping("api/createLibros")
	public Libros createLibros(@RequestBody Libros libro){
		return librosService.save(libro);
	}

	@PutMapping(path = "api/updateLibros")
	public Libros updateLibros(@RequestBody Libros updtLibros){
		int tmpID = updtLibros.getIdLibro();
		if(librosService.findById(tmpID).isPresent()){
			return librosService.save(updtLibros);
		}
		else{
			return null;
		}
	}

	@DeleteMapping(path = "api/deleteLibros/{id}")
	public void delete(@PathVariable("id") int idLibro){
		Optional<Libros> libroOptional = librosService.findById(idLibro);
			libroOptional.ifPresent(librosService::delete);
		}
	
}