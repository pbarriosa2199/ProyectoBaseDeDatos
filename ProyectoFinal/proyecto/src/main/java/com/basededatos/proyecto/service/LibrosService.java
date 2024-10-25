package com.basededatos.proyecto.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.basededatos.proyecto.model.entity.Libros;
import com.basededatos.proyecto.model.repository.LibrosRepository;

@Service
public class LibrosService {
	
	private final LibrosRepository librosRepository;

	public LibrosService(LibrosRepository librosRepository)
	{
		this.librosRepository = librosRepository;
	}

	public List<Libros> getAllLibros()
	{
		return(List<Libros>) librosRepository.findAll();
	}

	public Optional<Libros> findById(Integer id)
	{
		return librosRepository.findById(id);
	}

	public Libros save(Libros id)
	{
		return librosRepository.save(id);
	}

	public void delete(Libros id)
	{
		librosRepository.delete(id);
	}

}