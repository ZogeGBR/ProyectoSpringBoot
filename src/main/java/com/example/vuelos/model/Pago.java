package com.example.vuelos.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "pago")
@Inheritance(strategy = InheritanceType.JOINED)
public class Pago {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "El número de pago es obligatorio")
    @Min(value = 1, message = "El número de pago debe ser mayor a 0")
    @Column(name = "numero_pago")
    protected int numeroPago;

    @NotNull(message = "La cantidad de pago es obligatoria")
    @Min(value = 0, message = "La cantidad no puede ser negativa")
    @Column(name = "cantidad_pago")
    protected int cantidadPago;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public int getNumeroPago() { return numeroPago; }
    public void setNumeroPago(int numeroPago) { this.numeroPago = numeroPago; }
    public int getCantidadPago() { return cantidadPago; }
    public void setCantidadPago(int cantidadPago) { this.cantidadPago = cantidadPago; }
}
