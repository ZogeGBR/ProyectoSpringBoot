package com.example.vuelos.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

/**
 * Entidad central del sistema que representa un vuelo programado.
 *
 * <p>Un vuelo conecta un origen con un destino, tiene asignados un avión,
 * una aerolínea, un piloto y fechas de salida y llegada. Además puede
 * pasar por múltiples aeropuertos y tener distintas tarifas por clase.</p>
 *
 * <p>Relaciones:</p>
 * <ul>
 *   <li>{@code @ManyToOne} con {@link Avion}, {@link Aerolinea}, {@link Piloto}</li>
 *   <li>{@code @ManyToOne} con {@link Fecha} para salida y destino</li>
 *   <li>{@code @ManyToMany} con {@link Aeropuerto} (tabla {@code vuelo_aeropuerto})</li>
 *   <li>{@code @OneToMany} con {@link Tarifa} — se ignora en JSON</li>
 * </ul>
 *
 * @author Zoe García Badiola
 * @version 1.0
 * @see Avion
 * @see Aerolinea
 * @see Piloto
 * @see Aeropuerto
 * @see Tarifa
 * @see Reserva
 */
@Entity
@Table(name = "vuelo")
public class Vuelo {

    /** Identificador único generado automáticamente por la base de datos. */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** Número identificador del vuelo (ej: 5401). */
    @NotNull(message = "El número de vuelo es obligatorio")
    @Min(value = 1, message = "El número de vuelo debe ser mayor a 0")
    @Column(name = "numero_vuelo", nullable = false)
    private int numeroVuelo;

    /** Avión asignado a este vuelo. */
    @NotNull(message = "El avión es obligatorio")
    @ManyToOne
    @JoinColumn(name = "avion_id", nullable = false)
    @JsonIgnoreProperties({"asientos", "hibernateLazyInitializer", "handler"})
    private Avion avion;

    /**
     * Lista de aeropuertos del vuelo (origen, escalas, destino).
     * Relación muchos a muchos a través de la tabla {@code vuelo_aeropuerto}.
     */
    @ManyToMany
    @JoinTable(name = "vuelo_aeropuerto",
        joinColumns = @JoinColumn(name = "vuelo_id"),
        inverseJoinColumns = @JoinColumn(name = "aeropuerto_id"))
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private List<Aeropuerto> aeropuertos = new ArrayList<>();

    /** Fecha de salida del vuelo. */
    @ManyToOne
    @JoinColumn(name = "salida_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Fecha salida;

    /** Fecha de llegada al destino. */
    @ManyToOne
    @JoinColumn(name = "destino_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Fecha destino;

    /** Aerolínea que opera el vuelo. */
    @NotNull(message = "La aerolínea es obligatoria")
    @ManyToOne
    @JoinColumn(name = "aerolinea_id", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Aerolinea aerolinea;

    /** Piloto asignado a este vuelo. */
    @NotNull(message = "El piloto es obligatorio")
    @ManyToOne
    @JoinColumn(name = "piloto_id", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Piloto piloto;

    /**
     * Tarifas disponibles para este vuelo por clase de servicio.
     * Se ignora en JSON para evitar referencias circulares con {@link Tarifa}.
     */
    @OneToMany(mappedBy = "vuelo", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<Tarifa> tarifas = new ArrayList<>();

    /** @return el ID interno del registro */
    public Long getId() { return id; }
    /** @param id identificador asignado por la base de datos */
    public void setId(Long id) { this.id = id; }
    /** @return el número del vuelo */
    public int getNumeroVuelo() { return numeroVuelo; }
    /** @param numeroVuelo número identificador del vuelo */
    public void setNumeroVuelo(int numeroVuelo) { this.numeroVuelo = numeroVuelo; }
    /** @return el avión asignado */
    public Avion getAvion() { return avion; }
    /** @param avion el avión que realiza el vuelo */
    public void setAvion(Avion avion) { this.avion = avion; }
    /** @return la lista de aeropuertos del vuelo */
    public List<Aeropuerto> getAeropuertos() { return aeropuertos; }

    /**
     * Agrega un aeropuerto a la ruta del vuelo.
     * @param a el aeropuerto a agregar
     */
    public void addAeropuerto(Aeropuerto a) { aeropuertos.add(a); }

    /**
     * Elimina un aeropuerto de la ruta del vuelo.
     * @param a el aeropuerto a eliminar
     * @return {@code true} si estaba en la lista y fue eliminado
     */
    public boolean removeAeropuerto(Aeropuerto a) { return aeropuertos.remove(a); }

    /** @return la fecha de salida */
    public Fecha getSalida() { return salida; }
    /** @param salida fecha de salida del vuelo */
    public void setSalida(Fecha salida) { this.salida = salida; }
    /** @return la fecha de destino */
    public Fecha getDestino() { return destino; }
    /** @param destino fecha de llegada al destino */
    public void setDestino(Fecha destino) { this.destino = destino; }
    /** @return la aerolínea operadora */
    public Aerolinea getAerolinea() { return aerolinea; }
    /** @param aerolinea la aerolínea que opera el vuelo */
    public void setAerolinea(Aerolinea aerolinea) { this.aerolinea = aerolinea; }
    /** @return el piloto asignado */
    public Piloto getPiloto() { return piloto; }
    /** @param piloto el piloto que conduce el vuelo */
    public void setPiloto(Piloto piloto) { this.piloto = piloto; }
    /** @return la lista de tarifas del vuelo */
    public List<Tarifa> getTarifas() { return tarifas; }

    /**
     * Agrega una tarifa al vuelo si no está ya incluida.
     * @param t la tarifa a agregar
     */
    public void addTarifa(Tarifa t) { if (!tarifas.contains(t)) tarifas.add(t); }

    /**
     * Elimina una tarifa del vuelo y rompe la relación bidireccional.
     * @param t la tarifa a eliminar
     */
    public void removeTarifa(Tarifa t) { t.setVuelo(null); tarifas.remove(t); }
}
