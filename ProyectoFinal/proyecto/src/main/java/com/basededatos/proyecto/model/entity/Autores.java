package com.basededatos.proyecto.model.entity;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Table(name = "autores")
@Entity
public class Autores {
	@SuppressWarnings("deprecation")
    @Id
    @GenericGenerator(name = "autores", strategy = "enhanced-table", parameters = {
        @org.hibernate.annotations.Parameter(name = "autores", value = "sequence_autores")
    })
    @GeneratedValue(generator = "sequence_autores", strategy = GenerationType.TABLE)
    @SequenceGenerator(name = "sequence_autores", allocationSize = 1)  
    private int idAutor;
    @Column(nullable = false)
    private String nombre;
    private String biografia;
}