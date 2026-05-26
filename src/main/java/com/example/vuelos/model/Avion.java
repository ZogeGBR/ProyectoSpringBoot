package com.example.vuelos.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

/**
 * Entidad que representa un avión de la flota aérea.
 *
 * <p>Implementa la interfaz {@link Especificacion}, que define los métodos
 * {@code tipoTurbina()} y {@code tipoAvion()} según el diagrama UML del proyecto.</p>
 *
 * <p>Un avión puede tener múltiples {@link Asiento}, organizados por fila,
 * letra y clase de servicio ({@link Clase}). La lista de asientos se ignora
 * en la serialización JSON para evitar referencias circulares.</p>
 *
 * @author Zoe García Badiola
 * @version 1.0
 * @see Especificacion
 * @see Asiento
 * @see Vuelo
 */
@Entity
@Table(name = "avion")
public class Avion implements Especificacion {

    /** Identificador único generado automáticamente por la base de datos. */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** Número identificador del avión en la flota. */
    @NotNull(message = "El número de avión es obligatorio")
    @Min(value = 1, message = "El número de avión debe ser mayor a 0")
    @Column(name = "numero_avion", nullable = false)
    private int numeroAvion;

    /**
     * Lista de asientos del avión.
     * Se ignora en JSON para evitar referencias circulares con {@link Asiento}.
     */
    @OneToMany(mappedBy = "avion", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<Asiento> asientos = new ArrayList<>();

    /** @return el ID interno del registro */
    public Long getId() { return id; }
    /** @param id identificador asignado por la base de datos */
    public void setId(Long id) { this.id = id; }
    /** @return el número del avión en la flota */
    public int getNumeroAvion() { return numeroAvion; }
    /** @param numeroAvion número identificador, mayor a 0 */
    public void setNumeroAvion(int numeroAvion) { this.numeroAvion = numeroAvion; }
    /** @return lista de asientos del avión */
    public List<Asiento> getAsientos() { return asientos; }

    /**
     * Agrega un asiento al avión y establece la relación bidireccional.
     * @param asiento el asiento a agregar
     */
    public void addAsiento(Asiento asiento) { asiento.setAvion(this); asientos.add(asiento); }

    /**
     * Elimina un asiento del avión y rompe la relación bidireccional.
     * @param asiento el asiento a eliminar
     * @return {@code true} si el asiento estaba en la lista y fue eliminado
     */
    public boolean removeAsiento(Asiento asiento) { asiento.setAvion(null); return asientos.remove(asiento); }

    /**
     * {@inheritDoc}
     * @return tipo de turbina del avión (implementación pendiente)
     */
    @Override public String tipoTurbina() { return null; }

    /**
     * {@inheritDoc}
     * @return modelo del avión (implementación pendiente)
     */
    @Override public String tipoAvion() { return null; }
}
