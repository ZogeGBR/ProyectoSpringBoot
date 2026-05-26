package com.example.vuelos.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

/**
 * Entidad que representa una tarjeta de pago (débito o crédito).
 *
 * <p>Hereda de {@link Pago} los campos {@code numeroPago} y {@code cantidadPago}.
 * Agrega el número de tarjeta (de tipo {@code long} para soportar los
 * 16 dígitos de una tarjeta real) y el tipo ({@link TipoTarjeta}).</p>
 *
 * <p>Una tarjeta pertenece a un {@link Usuario} (relación {@code @ManyToOne}).</p>
 *
 * @author Zoe García Badiola
 * @version 1.0
 * @see Pago
 * @see TipoTarjeta
 * @see Usuario
 */
@Entity
@Table(name = "tarjeta")
public class Tarjeta extends Pago {

    /** Número de la tarjeta. Usa {@code long} para soportar 16 dígitos. */
    @Min(value = 1, message = "El número de tarjeta debe ser mayor a 0")
    @Column(name = "numero_tarjeta", nullable = false)
    private long numeroTarjeta;

    /** Tipo de tarjeta: {@code DEBITO} o {@code CREDITO}. */
    @NotNull(message = "El tipo de tarjeta es obligatorio")
    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_tarjeta", nullable = false)
    private TipoTarjeta tipoTarjeta;

    /** Usuario propietario de esta tarjeta. */
    @ManyToOne
    @JoinColumn(name = "usuario_id")
    @JsonIgnoreProperties({"tarjetas", "hibernateLazyInitializer", "handler"})
    private Usuario usuario;

    /** @return el número de la tarjeta (16 dígitos) */
    public long getNumeroTarjeta() { return numeroTarjeta; }
    /** @param numeroTarjeta número de tarjeta, debe ser mayor a 0 */
    public void setNumeroTarjeta(long numeroTarjeta) { this.numeroTarjeta = numeroTarjeta; }
    /** @return el tipo de tarjeta (DEBITO o CREDITO) */
    public TipoTarjeta getTipoTarjeta() { return tipoTarjeta; }
    /** @param tipoTarjeta tipo de tarjeta, no puede ser nulo */
    public void setTipoTarjeta(TipoTarjeta tipoTarjeta) { this.tipoTarjeta = tipoTarjeta; }
    /** @return el usuario propietario */
    public Usuario getUsuario() { return usuario; }
    /** @param usuario el usuario al que pertenece esta tarjeta */
    public void setUsuario(Usuario usuario) { this.usuario = usuario; }
}
