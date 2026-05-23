package com.example.vuelos.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "piloto")
public class Piloto extends Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "El número de piloto es obligatorio")
    @Min(value = 1, message = "El número de piloto debe ser mayor a 0")
    @Column(name = "numero_piloto", nullable = false)
    private int numeroPiloto;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public int getNumeroPiloto() { return numeroPiloto; }
    public void setNumeroPiloto(int numeroPiloto) { this.numeroPiloto = numeroPiloto; }
}
