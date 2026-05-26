package com.example.vuelos.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

/**
 * Entidad que representa una tarifa de precio para un vuelo según la clase.
 *
 * <p>Cada {@link Vuelo} puede tener múltiples tarifas, una por cada
 * {@link Clase} de servicio (BUSINESS, TURISTA, ECONOMY). La tarifa
 * incluye el precio base y el porcentaje de impuesto.</p>
 *
 * @author Zoe García Badiola
 * @version 1.0
 * @see Vuelo
 * @see Clase
 */
@Entity
@Table(name = "tarifa")
public class Tarifa {

    /** Identificador único generado automáticamente por la base de datos. */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** Número identificador de la tarifa. */
    @NotNull(message = "El número de tarifa es obligatorio")
    @Min(value = 1, message = "El número debe ser mayor a 0")
    @Column(name = "numero_tarifa", nullable = false)
    private int numeroTarifa;

    /** Impuesto aplicado al precio base. No puede ser negativo. */
    @Min(value = 0, message = "El impuesto no puede ser negativo")
    @Column(name = "impuesto_tarifa", nullable = false)
    private int impuestoTarifa;

    /** Precio base de la tarifa. No puede ser negativo. */
    @Min(value = 0, message = "El precio no puede ser negativo")
    @Column(name = "precio_tarifa", nullable = false)
    private int precioTarifa;

    /** Clase de servicio a la que aplica esta tarifa. */
    @NotNull(message = "La clase es obligatoria")
    @Enumerated(EnumType.STRING)
    @Column(name = "clase_tarifa", nullable = false)
    private Clase claseTarifa;

    /** Vuelo al que pertenece esta tarifa. */
    @NotNull(message = "El vuelo es obligatorio")
    @ManyToOne
    @JoinColumn(name = "vuelo_id", nullable = false)
    @JsonIgnoreProperties({"tarifas", "aeropuertos", "hibernateLazyInitializer", "handler"})
    private Vuelo vuelo;

    /** @return el ID interno del registro */
    public Long getId() { return id; }
    /** @param id identificador asignado por la base de datos */
    public void setId(Long id) { this.id = id; }
    /** @return el número de tarifa */
    public int getNumeroTarifa() { return numeroTarifa; }
    /** @param n número identificador de la tarifa */
    public void setNumeroTarifa(int n) { this.numeroTarifa = n; }
    /** @return el impuesto aplicado */
    public int getImpuestoTarifa() { return impuestoTarifa; }
    /** @param i porcentaje o monto de impuesto */
    public void setImpuestoTarifa(int i) { this.impuestoTarifa = i; }
    /** @return el precio base */
    public int getPrecioTarifa() { return precioTarifa; }
    /** @param p precio base de la tarifa */
    public void setPrecioTarifa(int p) { this.precioTarifa = p; }
    /** @return la clase de servicio */
    public Clase getClaseTarifa() { return claseTarifa; }
    /** @param c clase de servicio (BUSINESS, TURISTA, ECONOMY) */
    public void setClaseTarifa(Clase c) { this.claseTarifa = c; }
    /** @return el vuelo al que pertenece esta tarifa */
    public Vuelo getVuelo() { return vuelo; }
    /** @param vuelo el vuelo asociado a esta tarifa */
    public void setVuelo(Vuelo vuelo) { this.vuelo = vuelo; }
}
