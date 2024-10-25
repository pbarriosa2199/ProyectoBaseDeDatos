package com.basededatos.proyecto.model.entity;

import java.util.Date;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Table(name = "prestamos")
@Entity
public class Prestamos {
	@SuppressWarnings("deprecation")
    @Id
    @GenericGenerator(name = "prestamos", strategy = "enhanced-table", parameters = {
        @org.hibernate.annotations.Parameter(name = "prestamos", value = "sequence_prestamos")
    })
    @GeneratedValue(generator = "sequence_prestamos", strategy = GenerationType.TABLE)
    @SequenceGenerator(name = "sequence_prestamos", allocationSize = 1)  
    private int idPrestamo;
    @Column(nullable = false)
    private Date fechaPrestamo;
    private Date fechaDevolucionPrevista;
    private Date fechaDevolucionReal;
    @ManyToOne
	@JoinColumn(name = "autores_idAutor")
	private Autores autor;
    @ManyToOne
	@JoinColumn(name = "libros_idLibro")
	private Libros libro;
}