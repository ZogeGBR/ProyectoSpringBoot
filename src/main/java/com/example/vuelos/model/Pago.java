package com.example.vuelos.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

/**
 * Entidad base que representa un pago en el sistema.
 *
 * <p>Utiliza la estrategia de herencia {@code JOINED}: cada subclase
 * tiene su propia tabla con los campos adicionales, y esta tabla
 * {@code pago} contiene los campos comunes ({@code numeroPago}, {@code cantidadPago}).</p>
 *
 * <p>Subclase directa: {@link Tarjeta}.</p>
 *
 * <p>Una instancia de {@code Pago} se asocia a una {@link Reserva}
 * mediante una relación {@code @OneToOne}.</p>
 *
 * @author Zoe García Badiola
 * @version 1.0
 * @see Tarjeta
 * @see Reserva
 */
@Entity
@Table(name = "pago")
@Inheritance(strategy = InheritanceType.JOINED)
public class Pago {

    /** Identificador único generado automáticamente por la base de datos. */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** Número identificador del pago. Debe ser mayor a 0. */
    @NotNull(message = "El número de pago es obligatorio")
    @Min(value = 1, message = "El número de pago debe ser mayor a 0")
    @Column(name = "numero_pago")
    protected int numeroPago;

    /** Monto total del pago. No puede ser negativo. */
    @NotNull(message = "La cantidad de pago es obligatoria")
    @Min(value = 0, message = "La cantidad no puede ser negativa")
    @Column(name = "cantidad_pago")
    protected int cantidadPago;

    /** @return el ID interno del registro */
    public Long getId() { return id; }
    /** @param id identificador asignado por la base de datos */
    public void setId(Long id) { this.id = id; }
    /** @return el número de pago */
    public int getNumeroPago() { return numeroPago; }
    /** @param numeroPago número identificador del pago */
    public void setNumeroPago(int numeroPago) { this.numeroPago = numeroPago; }
    /** @return el monto del pago */
    public int getCantidadPago() { return cantidadPago; }
    /** @param cantidadPago monto total, no puede ser negativo */
    public void setCantidadPago(int cantidadPago) { this.cantidadPago = cantidadPago; }
}
