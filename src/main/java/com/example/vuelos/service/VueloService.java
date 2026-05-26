package com.example.vuelos.service;

import com.example.vuelos.model.Vuelo;
import java.util.List;

/**
 * Interfaz de servicio para la gestión de {@link Vuelo}.
 *
 * <p>Define el contrato de operaciones CRUD implementado por
 * {@link VueloServiceImpl}. La capa Service separa la lógica de negocio
 * del acceso a datos (Repository) y de la capa web (Controller).</p>
 *
 * @author Zoe García Badiola
 * @version 1.0
 * @see VueloServiceImpl
 */
public interface VueloService {

    /**
     * Obtiene todos los vuelos registrados en el sistema.
     * @return lista con todos los vuelos, vacía si no hay ninguno
     */
    List<Vuelo> getAllVuelos();

    /**
     * Busca un vuelo por su ID interno.
     * @param id identificador del vuelo
     * @return el vuelo encontrado
     * @throws RuntimeException si no existe un vuelo con ese ID
     */
    Vuelo getVueloById(Long id);

    /**
     * Crea y persiste un nuevo vuelo en la base de datos.
     * Resuelve automáticamente las entidades relacionadas (avión, aerolínea, piloto).
     * @param vuelo datos del vuelo a crear
     * @return el vuelo creado con su ID asignado
     */
    Vuelo createVuelo(Vuelo vuelo);

    /**
     * Actualiza los datos de un vuelo existente.
     * @param id   ID del vuelo a actualizar
     * @param vuelo nuevos datos del vuelo
     * @return el vuelo actualizado
     * @throws RuntimeException si no existe un vuelo con ese ID
     */
    Vuelo updateVuelo(Long id, Vuelo vuelo);

    /**
     * Elimina un vuelo por su ID.
     * @param id identificador del vuelo a eliminar
     */
    void deleteVuelo(Long id);
}
