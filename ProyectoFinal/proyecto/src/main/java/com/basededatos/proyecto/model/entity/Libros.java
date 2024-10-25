package com.basededatos.proyecto.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Table(name = "libros")
@Entity
public class Libros {
	@Id
	private int idLibro;
	@Column(nullable = false)
	private String titulo;
	private String editorial;
	private int anioPublicacion;
	private int ejemplaresDisponibles;
	@ManyToOne
	@JoinColumn(name = "idAutor")
	private Autores autor;
}