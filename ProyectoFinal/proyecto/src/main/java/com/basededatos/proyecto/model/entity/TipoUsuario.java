package com.basededatos.proyecto.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Table(name = "tipo_usuario")
@Entity
public class TipoUsuario {
	@Id
	private int idTipoUsuario;
	@Column(nullable = false)
	private String nombreUsuario;
}