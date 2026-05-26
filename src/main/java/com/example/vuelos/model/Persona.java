package com.example.vuelos.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

/**
 * Clase base abstracta para las entidades que representan personas físicas.
 *
 * <p>Utiliza {@code @MappedSuperclass}: sus campos se heredan directamente
 * en las tablas de las subclases ({@link Piloto}, {@link Usuario}) sin
 * crear una tabla propia en la base de datos.</p>
 *
 * <p>Los atributos son {@code protected} para que las subclases puedan
 * accederlos directamente, respetando el principio de encapsulamiento
 * en contextos de herencia.</p>
 *
 * @author Zoe García Badiola
 * @version 1.0
 * @see Piloto
 * @see Usuario
 */
@MappedSuperclass
public class Persona {

    /** DNI de la persona. Debe tener al menos 7 dígitos. */
    @NotNull(message = "El DNI es obligatorio")
    @Min(value = 1000000, message = "El DNI debe tener al menos 7 dígitos")
    @Column(name = "dni_persona", nullable = false)
    protected int dniPersona;

    /** Nombre de pila de la persona. No puede estar vacío. */
    @NotBlank(message = "El nombre es obligatorio")
    @Column(name = "nombre_persona", nullable = false)
    protected String nombrePersona;

    /** Apellido de la persona. No puede estar vacío. */
    @NotBlank(message = "El apellido es obligatorio")
    @Column(name = "apellido_persona", nullable = false)
    protected String apellidoPersona;

    /** Constructor vacío requerido por JPA. */
    public Persona() {}

    /**
     * Obtiene el DNI de la persona.
     * @return el número de documento nacional de identidad
     */
    public int getDniPersona() { return dniPersona; }

    /**
     * Establece el DNI de la persona.
     * @param dniPersona número de DNI (mínimo 7 dígitos)
     */
    public void setDniPersona(int dniPersona) { this.dniPersona = dniPersona; }

    /**
     * Obtiene el nombre de la persona.
     * @return el nombre de pila
     */
    public String getNombrePersona() { return nombrePersona; }

    /**
     * Establece el nombre de la persona.
     * @param nombrePersona nombre de pila, no puede ser nulo ni vacío
     */
    public void setNombrePersona(String nombrePersona) { this.nombrePersona = nombrePersona; }

    /**
     * Obtiene el apellido de la persona.
     * @return el apellido
     */
    public String getApellidoPersona() { return apellidoPersona; }

    /**
     * Establece el apellido de la persona.
     * @param apellidoPersona apellido, no puede ser nulo ni vacío
     */
    public void setApellidoPersona(String apellidoPersona) { this.apellidoPersona = apellidoPersona; }
}
