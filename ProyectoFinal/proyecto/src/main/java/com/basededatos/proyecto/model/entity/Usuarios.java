package com.basededatos.proyecto.model.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Table(name = "usuarios")
@Entity
public class Usuarios {
	@Id
	private int idUsuario;
	@Column(nullable = false)
	private String nombre;
	private String apellido;
	private String numeroIdentificacion;
	private String correoElectronico;
	private String telefono;
	@ManyToOne
	@JoinColumn(name = "idTipoUsuario")
	private TipoUsuario tipoUsuario;
	private Date fechaRegistro;
}