package com.example.vuelos.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Min;
import java.util.ArrayList;
import java.util.List;

/**
 * Entidad que representa un usuario registrado en el sistema.
 *
 * <p>Hereda de {@link Persona} los campos comunes: {@code dniPersona},
 * {@code nombrePersona} y {@code apellidoPersona}. Agrega datos de cuenta:
 * número de usuario, contraseña y correo electrónico único.</p>
 *
 * <p>Un usuario puede tener múltiples {@link Tarjeta} de pago asociadas
 * y puede realizar {@link Reserva} de vuelos y {@link Consulta}.</p>
 *
 * <p>La lista de tarjetas está marcada con {@code @JsonIgnore} para evitar
 * referencias circulares al serializar a JSON.</p>
 *
 * @author Zoe García Badiola
 * @version 1.0
 * @see Persona
 * @see Reserva
 * @see Tarjeta
 */
@Entity
@Table(name = "usuario")
public class Usuario extends Persona {

    /** Identificador único generado automáticamente por la base de datos. */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** Número identificador del usuario en el sistema. */
    @NotNull(message = "El número de usuario es obligatorio")
    @Min(value = 1, message = "El número de usuario debe ser mayor a 0")
    @Column(name = "numero_usuario", nullable = false)
    private int numeroUsuario;

    /** Contraseña de acceso del usuario. No puede estar vacía. */
    @NotBlank(message = "La contraseña es obligatoria")
    @Column(name = "contrasenia_usuario", nullable = false)
    private String contraseniaUsuario;

    /** Correo electrónico del usuario. Debe ser único y tener formato válido. */
    @NotBlank(message = "El correo electrónico es obligatorio")
    @Email(message = "El correo electrónico no es válido")
    @Column(name = "correo_electronico_usuario", unique = true, nullable = false)
    private String correoElectronicoUsuario;

    /**
     * Lista de tarjetas de pago del usuario.
     * Se ignora en la serialización JSON para evitar referencias circulares.
     */
    @OneToMany(mappedBy = "usuario")
    @JsonIgnore
    private List<Tarjeta> tarjetas = new ArrayList<>();

    /** @return el ID interno del registro */
    public Long getId() { return id; }
    /** @param id identificador asignado por la base de datos */
    public void setId(Long id) { this.id = id; }
    /** @return el número de usuario */
    public int getNumeroUsuario() { return numeroUsuario; }
    /** @param numeroUsuario número identificador, mayor a 0 */
    public void setNumeroUsuario(int numeroUsuario) { this.numeroUsuario = numeroUsuario; }
    /** @return la contraseña del usuario */
    public String getContraseniaUsuario() { return contraseniaUsuario; }
    /** @param c la nueva contraseña */
    public void setContraseniaUsuario(String c) { this.contraseniaUsuario = c; }
    /** @return el correo electrónico */
    public String getCorreoElectronicoUsuario() { return correoElectronicoUsuario; }
    /** @param c el correo electrónico con formato válido */
    public void setCorreoElectronicoUsuario(String c) { this.correoElectronicoUsuario = c; }
    /** @return lista de tarjetas asociadas al usuario */
    public List<Tarjeta> getTarjetas() { return tarjetas; }
    /** @param tarjetas lista de tarjetas a asociar */
    public void setTarjetas(List<Tarjeta> tarjetas) { this.tarjetas = tarjetas; }
}
