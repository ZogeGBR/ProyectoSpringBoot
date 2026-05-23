package com.example.vuelos.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "aerolinea")
public class Aerolinea {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El nombre de la aerolínea es obligatorio")
    @Column(name = "nombre_aerolinea", nullable = false)
    private String nombreAerolinea;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNombreAerolinea() { return nombreAerolinea; }
    public void setNombreAerolinea(String nombreAerolinea) { this.nombreAerolinea = nombreAerolinea; }
}
