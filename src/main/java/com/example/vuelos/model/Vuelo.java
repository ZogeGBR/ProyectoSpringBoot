package com.example.vuelos.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "vuelo")
public class Vuelo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "El número de vuelo es obligatorio")
    @Min(value = 1, message = "El número de vuelo debe ser mayor a 0")
    @Column(name = "numero_vuelo", nullable = false)
    private int numeroVuelo;

    @NotNull(message = "El avión es obligatorio")
    @ManyToOne
    @JoinColumn(name = "avion_id", nullable = false)
    @JsonIgnoreProperties({"asientos", "hibernateLazyInitializer", "handler"})
    private Avion avion;

    @ManyToMany
    @JoinTable(name = "vuelo_aeropuerto",
        joinColumns = @JoinColumn(name = "vuelo_id"),
        inverseJoinColumns = @JoinColumn(name = "aeropuerto_id"))
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private List<Aeropuerto> aeropuertos = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "salida_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Fecha salida;

    @ManyToOne
    @JoinColumn(name = "destino_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Fecha destino;

    @NotNull(message = "La aerolínea es obligatoria")
    @ManyToOne
    @JoinColumn(name = "aerolinea_id", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Aerolinea aerolinea;

    @NotNull(message = "El piloto es obligatorio")
    @ManyToOne
    @JoinColumn(name = "piloto_id", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Piloto piloto;

    @OneToMany(mappedBy = "vuelo", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<Tarifa> tarifas = new ArrayList<>();

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public int getNumeroVuelo() { return numeroVuelo; }
    public void setNumeroVuelo(int numeroVuelo) { this.numeroVuelo = numeroVuelo; }
    public Avion getAvion() { return avion; }
    public void setAvion(Avion avion) { this.avion = avion; }
    public List<Aeropuerto> getAeropuertos() { return aeropuertos; }
    public void addAeropuerto(Aeropuerto a) { aeropuertos.add(a); }
    public boolean removeAeropuerto(Aeropuerto a) { return aeropuertos.remove(a); }
    public Fecha getSalida() { return salida; }
    public void setSalida(Fecha salida) { this.salida = salida; }
    public Fecha getDestino() { return destino; }
    public void setDestino(Fecha destino) { this.destino = destino; }
    public Aerolinea getAerolinea() { return aerolinea; }
    public void setAerolinea(Aerolinea aerolinea) { this.aerolinea = aerolinea; }
    public Piloto getPiloto() { return piloto; }
    public void setPiloto(Piloto piloto) { this.piloto = piloto; }
    public List<Tarifa> getTarifas() { return tarifas; }
    public void addTarifa(Tarifa t) { if (!tarifas.contains(t)) tarifas.add(t); }
    public void removeTarifa(Tarifa t) { t.setVuelo(null); tarifas.remove(t); }
}
