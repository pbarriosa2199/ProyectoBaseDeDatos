package com.basededatos.proyecto.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.basededatos.proyecto.model.entity.Autores;
import com.basededatos.proyecto.model.repository.AutoresRepository;

@Service
public class AutoresService {
	
	private final AutoresRepository autoresRepository;

	public AutoresService(AutoresRepository autoresRepository)
	{
		this.autoresRepository = autoresRepository;
	}

	public List<Autores> getAllAutores()
	{
		return(List<Autores>) autoresRepository.findAll();
	}

	public Optional<Autores> findById(Integer id)
	{
		return autoresRepository.findById(id);
	}

	public Autores save(Autores autor)
	{
		return autoresRepository.save(autor);
	}

	public void delete(Autores autor)
	{
		autoresRepository.delete(autor);
	}

}