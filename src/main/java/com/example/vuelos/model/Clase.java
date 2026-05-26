package com.example.vuelos.model;

/**
 * Enumeración que representa las clases de servicio disponibles en un vuelo.
 *
 * <p>Se utiliza en {@link Asiento} para indicar el tipo de asiento
 * y en {@link Tarifa} para asociar un precio a cada clase de servicio.</p>
 *
 * <ul>
 *   <li>{@code BUSINESS} — clase ejecutiva de alta gama</li>
 *   <li>{@code TURISTA} — clase económica estándar</li>
 *   <li>{@code ECONOMY} — clase de bajo costo</li>
 * </ul>
 *
 * @author Zoe García Badiola
 * @version 1.0
 * @see Asiento
 * @see Tarifa
 */
public enum Clase {
    /** Clase ejecutiva, mayor comodidad y servicio premium. */
    BUSINESS,
    /** Clase turista, servicio estándar. */
    TURISTA,
    /** Clase económica, tarifa reducida. */
    ECONOMY
}
