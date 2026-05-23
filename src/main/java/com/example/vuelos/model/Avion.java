package com.example.vuelos.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "avion")
public class Avion implements Especificacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "El número de avión es obligatorio")
    @Min(value = 1, message = "El número de avión debe ser mayor a 0")
    @Column(name = "numero_avion", nullable = false)
    private int numeroAvion;

    @OneToMany(mappedBy = "avion", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<Asiento> asientos = new ArrayList<>();

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public int getNumeroAvion() { return numeroAvion; }
    public void setNumeroAvion(int numeroAvion) { this.numeroAvion = numeroAvion; }
    public List<Asiento> getAsientos() { return asientos; }
    public void addAsiento(Asiento asiento) { asiento.setAvion(this); asientos.add(asiento); }
    public boolean removeAsiento(Asiento asiento) { asiento.setAvion(null); return asientos.remove(asiento); }

    @Override public String tipoTurbina() { return null; }
    @Override public String tipoAvion() { return null; }
}
