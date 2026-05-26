package com.example.vuelos.model;

/**
 * Interfaz que define las especificaciones técnicas de una aeronave.
 *
 * <p>Implementada por la clase {@link Avion} según el diagrama UML del proyecto.
 * Permite polimorfismo para acceder a las características técnicas
 * de distintos tipos de aeronaves sin depender de la implementación concreta.</p>
 *
 * @author Zoe García Badiola
 * @version 1.0
 * @see Avion
 */
public interface Especificacion {

    /**
     * Obtiene el tipo de turbina de la aeronave.
     *
     * @return descripción del tipo de turbina (ej: "turbofan", "turbohélice")
     */
    String tipoTurbina();

    /**
     * Obtiene el modelo o tipo de la aeronave.
     *
     * @return modelo del avión (ej: "Boeing 737", "Airbus A320")
     */
    String tipoAvion();
}
