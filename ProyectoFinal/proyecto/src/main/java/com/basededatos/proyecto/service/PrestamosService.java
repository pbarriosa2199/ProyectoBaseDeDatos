package com.basededatos.proyecto.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.basededatos.proyecto.model.entity.Prestamos;
import com.basededatos.proyecto.model.repository.PrestamosRepository;

@Service
public class PrestamosService {
	
	private final PrestamosRepository prestamosRepository;

	public PrestamosService(PrestamosRepository prestamosRepository)
	{
		this.prestamosRepository = prestamosRepository;
	}

	public List<Prestamos> getAllPrestamos()
	{
		return(List<Prestamos>) prestamosRepository.findAll();
	}

	public Optional<Prestamos> findById(Integer id)
	{
		return prestamosRepository.findById(id);
	}

	public Prestamos save(Prestamos id)
	{
		return prestamosRepository.save(id);
	}

	public void delete(Prestamos id)
	{
		prestamosRepository.delete(id);
	}

}