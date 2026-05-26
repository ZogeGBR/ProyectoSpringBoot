package com.example.vuelos.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

/**
 * Entidad que representa una aerolínea operadora de vuelos.
 *
 * <p>Cada {@link Vuelo} tiene una aerolínea asociada que indica
 * quién opera el servicio de transporte aéreo.</p>
 *
 * @author Zoe García Badiola
 * @version 1.0
 * @see Vuelo
 */
@Entity
@Table(name = "aerolinea")
public class Aerolinea {

    /** Identificador único generado automáticamente por la base de datos. */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** Nombre comercial de la aerolínea. No puede estar vacío. */
    @NotBlank(message = "El nombre de la aerolínea es obligatorio")
    @Column(name = "nombre_aerolinea", nullable = false)
    private String nombreAerolinea;

    /** @return el ID interno del registro */
    public Long getId() { return id; }
    /** @param id identificador asignado por la base de datos */
    public void setId(Long id) { this.id = id; }
    /** @return el nombre de la aerolínea */
    public String getNombreAerolinea() { return nombreAerolinea; }
    /** @param nombreAerolinea nombre comercial, no puede estar vacío */
    public void setNombreAerolinea(String nombreAerolinea) { this.nombreAerolinea = nombreAerolinea; }
}
