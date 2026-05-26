package com.example.vuelos.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

/**
 * Entidad que representa un piloto de la flota aérea.
 *
 * <p>Hereda de {@link Persona} los campos comunes: {@code dniPersona},
 * {@code nombrePersona} y {@code apellidoPersona}. Agrega el campo
 * {@code numeroPiloto} como identificador de negocio único.</p>
 *
 * <p>Se mapea a la tabla {@code piloto} en la base de datos, que contiene
 * tanto sus campos propios como los heredados de {@code Persona}.</p>
 *
 * @author Zoe García Badiola
 * @version 1.0
 * @see Persona
 */
@Entity
@Table(name = "piloto")
public class Piloto extends Persona {

    /** Identificador único generado automáticamente por la base de datos. */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** Número identificador del piloto como profesional de la aviación. */
    @NotNull(message = "El número de piloto es obligatorio")
    @Min(value = 1, message = "El número de piloto debe ser mayor a 0")
    @Column(name = "numero_piloto", nullable = false)
    private int numeroPiloto;

    /**
     * Obtiene el ID interno de la base de datos.
     * @return el identificador único del registro
     */
    public Long getId() { return id; }

    /**
     * Establece el ID interno (usado por JPA, no llamar manualmente).
     * @param id identificador asignado por la base de datos
     */
    public void setId(Long id) { this.id = id; }

    /**
     * Obtiene el número de piloto.
     * @return número identificador del piloto
     */
    public int getNumeroPiloto() { return numeroPiloto; }

    /**
     * Establece el número de piloto.
     * @param numeroPiloto número identificador, debe ser mayor a 0
     */
    public void setNumeroPiloto(int numeroPiloto) { this.numeroPiloto = numeroPiloto; }
}
