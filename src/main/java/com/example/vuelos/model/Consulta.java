package com.example.vuelos.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

/**
 * Entidad que representa una consulta realizada por un usuario.
 *
 * <p>Una consulta está asociada a un {@link Usuario} a través de
 * una relación {@code @ManyToOne} (un usuario puede tener múltiples
 * consultas). El número de consulta es el identificador de negocio.</p>
 *
 * @author Zoe García Badiola
 * @version 1.0
 * @see Usuario
 */
@Entity
@Table(name = "consulta")
public class Consulta {

    /** Identificador único generado automáticamente por la base de datos. */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** Número identificador de la consulta. */
    @Column(name = "numero_consulta", nullable = false)
    private int numeroConsulta;

    /** Usuario que realizó la consulta. */
    @ManyToOne
    @JoinColumn(name = "usuario_id")
    @JsonIgnoreProperties({"tarjetas", "hibernateLazyInitializer", "handler"})
    private Usuario usuario;

    /** @return el ID interno del registro */
    public Long getId() { return id; }
    /** @param id identificador asignado por la base de datos */
    public void setId(Long id) { this.id = id; }
    /** @return el número de consulta */
    public int getNumeroConsulta() { return numeroConsulta; }
    /** @param numeroConsulta número identificador de la consulta */
    public void setNumeroConsulta(int numeroConsulta) { this.numeroConsulta = numeroConsulta; }
    /** @return el usuario que realizó la consulta */
    public Usuario getUsuario() { return usuario; }
    /** @param usuario el usuario asociado a la consulta */
    public void setUsuario(Usuario usuario) { this.usuario = usuario; }
}
