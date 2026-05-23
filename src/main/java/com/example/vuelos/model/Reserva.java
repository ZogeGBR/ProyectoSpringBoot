package com.example.vuelos.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "reserva")
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "El número de reserva es obligatorio")
    @Min(value = 1, message = "El número de reserva debe ser mayor a 0")
    @Column(name = "numero_reserva", nullable = false)
    private int numeroReserva;

    @NotNull(message = "El vuelo es obligatorio")
    @ManyToOne
    @JoinColumn(name = "vuelo_id", nullable = false)
    @JsonIgnoreProperties({"tarifas", "aeropuertos", "hibernateLazyInitializer", "handler"})
    private Vuelo vuelo;

    @NotNull(message = "El usuario es obligatorio")
    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    @JsonIgnoreProperties({"tarjetas", "hibernateLazyInitializer", "handler"})
    private Usuario usuario;

    @OneToOne
    @JoinColumn(name = "pago_id")
    private Pago pago;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public int getNumeroReserva() { return numeroReserva; }
    public void setNumeroReserva(int numeroReserva) { this.numeroReserva = numeroReserva; }
    public Vuelo getVuelo() { return vuelo; }
    public void setVuelo(Vuelo vuelo) { this.vuelo = vuelo; }
    public Usuario getUsuario() { return usuario; }
    public void setUsuario(Usuario usuario) { this.usuario = usuario; }
    public Pago getPago() { return pago; }
    public void setPago(Pago pago) { this.pago = pago; }
}
