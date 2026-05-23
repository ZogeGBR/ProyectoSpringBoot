package com.example.vuelos.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Min;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "usuario")
public class Usuario extends Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "El número de usuario es obligatorio")
    @Min(value = 1, message = "El número de usuario debe ser mayor a 0")
    @Column(name = "numero_usuario", nullable = false)
    private int numeroUsuario;

    @NotBlank(message = "La contraseña es obligatoria")
    @Column(name = "contrasenia_usuario", nullable = false)
    private String contraseniaUsuario;

    @NotBlank(message = "El correo electrónico es obligatorio")
    @Email(message = "El correo electrónico no es válido")
    @Column(name = "correo_electronico_usuario", unique = true, nullable = false)
    private String correoElectronicoUsuario;

    @OneToMany(mappedBy = "usuario")
    @JsonIgnore
    private List<Tarjeta> tarjetas = new ArrayList<>();

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public int getNumeroUsuario() { return numeroUsuario; }
    public void setNumeroUsuario(int numeroUsuario) { this.numeroUsuario = numeroUsuario; }
    public String getContraseniaUsuario() { return contraseniaUsuario; }
    public void setContraseniaUsuario(String c) { this.contraseniaUsuario = c; }
    public String getCorreoElectronicoUsuario() { return correoElectronicoUsuario; }
    public void setCorreoElectronicoUsuario(String c) { this.correoElectronicoUsuario = c; }
    public List<Tarjeta> getTarjetas() { return tarjetas; }
    public void setTarjetas(List<Tarjeta> tarjetas) { this.tarjetas = tarjetas; }
}
