package com.example.vuelos.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

/**
 * Entidad que representa una ciudad del sistema.
 *
 * <p>Las ciudades son referenciadas por los {@link Aeropuerto}
 * para indicar su ubicación geográfica.</p>
 *
 * @author Zoe García Badiola
 * @version 1.0
 * @see Aeropuerto
 */
@Entity
@Table(name = "ciudad")
public class Ciudad {

    /** Identificador único generado automáticamente por la base de datos. */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** Nombre de la ciudad. No puede estar vacío. */
    @NotBlank(message = "El nombre de la ciudad es obligatorio")
    @Column(name = "nombre_ciudad", nullable = false)
    private String nombreCiudad;

    /** @return el ID interno del registro */
    public Long getId() { return id; }
    /** @param id identificador asignado por la base de datos */
    public void setId(Long id) { this.id = id; }
    /** @return el nombre de la ciudad */
    public String getNombreCiudad() { return nombreCiudad; }
    /** @param nombreCiudad nombre de la ciudad, no puede estar vacío */
    public void setNombreCiudad(String nombreCiudad) { this.nombreCiudad = nombreCiudad; }
}
