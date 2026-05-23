package com.example.vuelos.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

@Entity
@Table(name = "asiento")
public class Asiento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "fila_asiento", nullable = false)
    private int filaAsiento;

    @Column(name = "letra_asiento", nullable = false, length = 1)
    private char letraAsiento;

    @Enumerated(EnumType.STRING)
    @Column(name = "clase_asiento", nullable = false)
    private Clase claseAsiento;

    @ManyToOne
    @JoinColumn(name = "avion_id", nullable = false)
    @JsonIgnoreProperties({"asientos", "hibernateLazyInitializer", "handler"})
    private Avion avion;

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public int getFilaAsiento() { return filaAsiento; }
    public void setFilaAsiento(int filaAsiento) { this.filaAsiento = filaAsiento; }

    public char getLetraAsiento() { return letraAsiento; }
    public void setLetraAsiento(char letraAsiento) { this.letraAsiento = letraAsiento; }

    public Clase getClaseAsiento() { return claseAsiento; }
    public void setClaseAsiento(Clase claseAsiento) { this.claseAsiento = claseAsiento; }

    public Avion getAvion() { return avion; }
    public void setAvion(Avion avion) { this.avion = avion; }
}
