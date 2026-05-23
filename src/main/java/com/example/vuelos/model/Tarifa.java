package com.example.vuelos.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "tarifa")
public class Tarifa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "El número de tarifa es obligatorio")
    @Min(value = 1, message = "El número debe ser mayor a 0")
    @Column(name = "numero_tarifa", nullable = false)
    private int numeroTarifa;

    @Min(value = 0, message = "El impuesto no puede ser negativo")
    @Column(name = "impuesto_tarifa", nullable = false)
    private int impuestoTarifa;

    @Min(value = 0, message = "El precio no puede ser negativo")
    @Column(name = "precio_tarifa", nullable = false)
    private int precioTarifa;

    @NotNull(message = "La clase es obligatoria")
    @Enumerated(EnumType.STRING)
    @Column(name = "clase_tarifa", nullable = false)
    private Clase claseTarifa;

    @NotNull(message = "El vuelo es obligatorio")
    @ManyToOne
    @JoinColumn(name = "vuelo_id", nullable = false)
    @JsonIgnoreProperties({"tarifas", "aeropuertos", "hibernateLazyInitializer", "handler"})
    private Vuelo vuelo;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public int getNumeroTarifa() { return numeroTarifa; }
    public void setNumeroTarifa(int n) { this.numeroTarifa = n; }
    public int getImpuestoTarifa() { return impuestoTarifa; }
    public void setImpuestoTarifa(int i) { this.impuestoTarifa = i; }
    public int getPrecioTarifa() { return precioTarifa; }
    public void setPrecioTarifa(int p) { this.precioTarifa = p; }
    public Clase getClaseTarifa() { return claseTarifa; }
    public void setClaseTarifa(Clase c) { this.claseTarifa = c; }
    public Vuelo getVuelo() { return vuelo; }
    public void setVuelo(Vuelo vuelo) { this.vuelo = vuelo; }
}
