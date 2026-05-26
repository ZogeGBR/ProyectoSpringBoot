package com.example.vuelos.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

/**
 * Entidad que representa un aeropuerto del sistema.
 *
 * <p>Cada aeropuerto pertenece a una {@link Ciudad} y puede aparecer
 * en múltiples {@link Vuelo} a través de la relación {@code @ManyToMany}
 * (tabla intermedia {@code vuelo_aeropuerto}).</p>
 *
 * @author Zoe García Badiola
 * @version 1.0
 * @see Ciudad
 * @see Vuelo
 */
@Entity
@Table(name = "aeropuerto")
public class Aeropuerto {

    /** Identificador único generado automáticamente por la base de datos. */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** Nombre oficial del aeropuerto. */
    @Column(name = "nombre_aeropuerto", nullable = false)
    private String nombreAeropuerto;

    /** Ciudad donde está ubicado el aeropuerto. */
    @ManyToOne
    @JoinColumn(name = "ciudad_id", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Ciudad ciudad;

    /** @return el ID interno del registro */
    public Long getId() { return id; }
    /** @param id identificador asignado por la base de datos */
    public void setId(Long id) { this.id = id; }
    /** @return el nombre del aeropuerto */
    public String getNombreAeropuerto() { return nombreAeropuerto; }
    /** @param nombreAeropuerto nombre oficial del aeropuerto */
    public void setNombreAeropuerto(String nombreAeropuerto) { this.nombreAeropuerto = nombreAeropuerto; }
    /** @return la ciudad donde está ubicado */
    public Ciudad getCiudad() { return ciudad; }
    /** @param ciudad ciudad de ubicación del aeropuerto */
    public void setCiudad(Ciudad ciudad) { this.ciudad = ciudad; }
}
