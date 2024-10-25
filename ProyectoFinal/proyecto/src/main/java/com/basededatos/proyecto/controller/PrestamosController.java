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

import com.basededatos.proyecto.model.entity.Prestamos;
import com.basededatos.proyecto.service.PrestamosService;

@RestController
public class PrestamosController {
	@Autowired
	private PrestamosService prestamosService;

	@GetMapping("api/prestamosList")
	public List<Prestamos> getAllPrestamos(){
		return prestamosService.getAllPrestamos();
	}

	@GetMapping("api/prestamoById/{idPrestamo}")
	public Prestamos getPrestamosById(@PathVariable("idPrestamo") int idPrestamo){
		Optional<Prestamos> prestamosOptional = prestamosService.findById(idPrestamo);
		return prestamosOptional.orElse(null);
	}

	@PostMapping("api/createPrestamos")
	public Prestamos createPrestamos(@RequestBody Prestamos prestamo){
		return prestamosService.save(prestamo);
	}

	@PutMapping(path = "api/updatePrestamos")
	public Prestamos updatePrestamos(@RequestBody Prestamos updtPrestamo){
		int tmpID = updtPrestamo.getIdPrestamo();
		if(prestamosService.findById(tmpID).isPresent()){
			return prestamosService.save(updtPrestamo);
		}
		else{
			return null;
		}
	}

	@DeleteMapping(path = "api/deletePrestamos/{id}")
	public void delete(@PathVariable("id") int idPrestamo){
		Optional<Prestamos> prestamoOptional = prestamosService.findById(idPrestamo);
			prestamoOptional.ifPresent(prestamosService::delete);
		}
	
}