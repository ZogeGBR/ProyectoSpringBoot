package com.example.vuelos.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "tarjeta")
public class Tarjeta extends Pago {

    @Min(value = 1, message = "El número de tarjeta debe ser mayor a 0")
    @Column(name = "numero_tarjeta", nullable = false)
    private long numeroTarjeta;

    @NotNull(message = "El tipo de tarjeta es obligatorio")
    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_tarjeta", nullable = false)
    private TipoTarjeta tipoTarjeta;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    @JsonIgnoreProperties({"tarjetas", "hibernateLazyInitializer", "handler"})
    private Usuario usuario;

    public long getNumeroTarjeta() { return numeroTarjeta; }
    public void setNumeroTarjeta(long numeroTarjeta) { this.numeroTarjeta = numeroTarjeta; }
    public TipoTarjeta getTipoTarjeta() { return tipoTarjeta; }
    public void setTipoTarjeta(TipoTarjeta tipoTarjeta) { this.tipoTarjeta = tipoTarjeta; }
    public Usuario getUsuario() { return usuario; }
    public void setUsuario(Usuario usuario) { this.usuario = usuario; }
}
