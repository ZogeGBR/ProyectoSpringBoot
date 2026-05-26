package com.example.vuelos.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

/**
 * Entidad que representa un asiento dentro de un avión.
 *
 * <p>Cada asiento se identifica por su fila, letra y clase de servicio.
 * Pertenece a un {@link Avion} a través de una relación {@code @ManyToOne}.</p>
 *
 * <p>La anotación {@code @JsonIgnoreProperties} sobre el campo {@code avion}
 * evita que se serialice la lista completa de asientos del avión al responder
 * con JSON, previniendo referencias circulares.</p>
 *
 * @author Zoe García Badiola
 * @version 1.0
 * @see Avion
 * @see Clase
 */
@Entity
@Table(name = "asiento")
public class Asiento {

    /** Identificador único generado automáticamente por la base de datos. */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** Número de fila del asiento dentro del avión. */
    @Column(name = "fila_asiento", nullable = false)
    private int filaAsiento;

    /** Letra del asiento (ej: 'A', 'B', 'C'). */
    @Column(name = "letra_asiento", nullable = false, length = 1)
    private char letraAsiento;

    /** Clase de servicio del asiento: BUSINESS, TURISTA o ECONOMY. */
    @Enumerated(EnumType.STRING)
    @Column(name = "clase_asiento", nullable = false)
    private Clase claseAsiento;

    /** Avión al que pertenece este asiento. */
    @ManyToOne
    @JoinColumn(name = "avion_id", nullable = false)
    @JsonIgnoreProperties({"asientos", "hibernateLazyInitializer", "handler"})
    private Avion avion;

    /** @return el ID interno del registro */
    public Long getId() { return id; }
    /** @param id identificador asignado por la base de datos */
    public void setId(Long id) { this.id = id; }
    /** @return el número de fila */
    public int getFilaAsiento() { return filaAsiento; }
    /** @param filaAsiento número de fila dentro del avión */
    public void setFilaAsiento(int filaAsiento) { this.filaAsiento = filaAsiento; }
    /** @return la letra del asiento */
    public char getLetraAsiento() { return letraAsiento; }
    /** @param letraAsiento letra identificadora del asiento (A-F) */
    public void setLetraAsiento(char letraAsiento) { this.letraAsiento = letraAsiento; }
    /** @return la clase de servicio del asiento */
    public Clase getClaseAsiento() { return claseAsiento; }
    /** @param claseAsiento clase de servicio (BUSINESS, TURISTA, ECONOMY) */
    public void setClaseAsiento(Clase claseAsiento) { this.claseAsiento = claseAsiento; }
    /** @return el avión al que pertenece este asiento */
    public Avion getAvion() { return avion; }
    /** @param avion el avión que contiene este asiento */
    public void setAvion(Avion avion) { this.avion = avion; }
}
