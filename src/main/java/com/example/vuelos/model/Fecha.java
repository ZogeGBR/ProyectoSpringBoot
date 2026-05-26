package com.example.vuelos.model;

import jakarta.persistence.*;
import java.time.LocalDate;

/**
 * Entidad que representa una fecha en el sistema.
 *
 * <p>Se utiliza en {@link Vuelo} para indicar la fecha de salida
 * y la fecha de destino del vuelo, como entidades independientes
 * según el diagrama UML del proyecto.</p>
 *
 * @author Zoe García Badiola
 * @version 1.0
 * @see Vuelo
 */
@Entity
@Table(name = "fecha")
public class Fecha {

    /** Identificador único generado automáticamente por la base de datos. */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** Fecha almacenada como {@code LocalDate} (año-mes-día). */
    @Column(name = "fecha", nullable = false)
    private LocalDate fecha;

    /** @return el ID interno del registro */
    public Long getId() { return id; }
    /** @param id identificador asignado por la base de datos */
    public void setId(Long id) { this.id = id; }
    /** @return la fecha en formato LocalDate */
    public LocalDate getFecha() { return fecha; }
    /** @param fecha la fecha a almacenar (ej: 2026-06-15) */
    public void setFecha(LocalDate fecha) { this.fecha = fecha; }
}
