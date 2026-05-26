package com.example.vuelos.model;

/**
 * Enumeración que representa los tipos de tarjeta de pago aceptados.
 *
 * <p>Utilizada en la entidad {@link Tarjeta} para clasificar
 * el instrumento de pago del usuario.</p>
 *
 * <ul>
 *   <li>{@code DEBITO} — débito directo de cuenta bancaria</li>
 *   <li>{@code CREDITO} — pago diferido con tarjeta de crédito</li>
 * </ul>
 *
 * @author Zoe García Badiola
 * @version 1.0
 * @see Tarjeta
 */
public enum TipoTarjeta {
    /** Tarjeta de débito bancario. */
    DEBITO,
    /** Tarjeta de crédito. */
    CREDITO
}
