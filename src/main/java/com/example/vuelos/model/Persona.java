package com.example.vuelos.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@MappedSuperclass
public class Persona {

    @NotNull(message = "El DNI es obligatorio")
    @Min(value = 1000000, message = "El DNI debe tener al menos 7 dígitos")
    @Column(name = "dni_persona", nullable = false)
    protected int dniPersona;

    @NotBlank(message = "El nombre es obligatorio")
    @Column(name = "nombre_persona", nullable = false)
    protected String nombrePersona;

    @NotBlank(message = "El apellido es obligatorio")
    @Column(name = "apellido_persona", nullable = false)
    protected String apellidoPersona;

    public Persona() {}
    public int getDniPersona() { return dniPersona; }
    public void setDniPersona(int dniPersona) { this.dniPersona = dniPersona; }
    public String getNombrePersona() { return nombrePersona; }
    public void setNombrePersona(String nombrePersona) { this.nombrePersona = nombrePersona; }
    public String getApellidoPersona() { return apellidoPersona; }
    public void setApellidoPersona(String apellidoPersona) { this.apellidoPersona = apellidoPersona; }
}
