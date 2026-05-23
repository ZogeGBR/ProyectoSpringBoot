package com.example.vuelos.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "ciudad")
public class Ciudad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El nombre de la ciudad es obligatorio")
    @Column(name = "nombre_ciudad", nullable = false)
    private String nombreCiudad;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNombreCiudad() { return nombreCiudad; }
    public void setNombreCiudad(String nombreCiudad) { this.nombreCiudad = nombreCiudad; }
}
