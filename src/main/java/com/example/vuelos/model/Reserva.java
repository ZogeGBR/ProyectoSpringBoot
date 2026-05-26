package com.example.vuelos.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

/**
 * Entidad que representa una reserva de vuelo realizada por un usuario.
 *
 * <p>Una reserva vincula un {@link Vuelo} con un {@link Usuario} y
 * opcionalmente con un {@link Pago}. El número de reserva es el
 * identificador de negocio (distinto del ID interno de la base de datos).</p>
 *
 * <p>La relación con {@code Pago} es {@code @OneToOne} sin cascada, lo que
 * permite referenciar un pago ya existente sin intentar recrearlo.</p>
 *
 * @author Zoe García Badiola
 * @version 1.0
 * @see Vuelo
 * @see Usuario
 * @see Pago
 */
@Entity
@Table(name = "reserva")
public class Reserva {

    /** Identificador único generado automáticamente por la base de datos. */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** Número identificador de la reserva para el usuario. */
    @NotNull(message = "El número de reserva es obligatorio")
    @Min(value = 1, message = "El número de reserva debe ser mayor a 0")
    @Column(name = "numero_reserva", nullable = false)
    private int numeroReserva;

    /** Vuelo que se está reservando. */
    @NotNull(message = "El vuelo es obligatorio")
    @ManyToOne
    @JoinColumn(name = "vuelo_id", nullable = false)
    @JsonIgnoreProperties({"tarifas", "aeropuertos", "hibernateLazyInitializer", "handler"})
    private Vuelo vuelo;

    /** Usuario que realiza la reserva. */
    @NotNull(message = "El usuario es obligatorio")
    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    @JsonIgnoreProperties({"tarjetas", "hibernateLazyInitializer", "handler"})
    private Usuario usuario;

    /** Pago asociado a esta reserva. Relación uno a uno sin cascada. */
    @OneToOne
    @JoinColumn(name = "pago_id")
    private Pago pago;

    /** @return el ID interno del registro */
    public Long getId() { return id; }
    /** @param id identificador asignado por la base de datos */
    public void setId(Long id) { this.id = id; }
    /** @return el número de reserva */
    public int getNumeroReserva() { return numeroReserva; }
    /** @param numeroReserva número identificador de la reserva */
    public void setNumeroReserva(int numeroReserva) { this.numeroReserva = numeroReserva; }
    /** @return el vuelo reservado */
    public Vuelo getVuelo() { return vuelo; }
    /** @param vuelo el vuelo a reservar */
    public void setVuelo(Vuelo vuelo) { this.vuelo = vuelo; }
    /** @return el usuario que realizó la reserva */
    public Usuario getUsuario() { return usuario; }
    /** @param usuario el usuario que realiza la reserva */
    public void setUsuario(Usuario usuario) { this.usuario = usuario; }
    /** @return el pago asociado a la reserva */
    public Pago getPago() { return pago; }
    /** @param pago el medio de pago utilizado */
    public void setPago(Pago pago) { this.pago = pago; }
}
