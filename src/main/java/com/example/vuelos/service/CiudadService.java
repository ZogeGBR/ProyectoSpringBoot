package com.example.vuelos.service;

import com.example.vuelos.model.Ciudad;
import java.util.List;

/**
 * Interfaz de servicio para la gestión de {@link Ciudad}.
 *
 * <p>Define el contrato de operaciones CRUD que debe implementar
 * {@code CiudadServiceImpl}. Separa la lógica de negocio de
 * los detalles de acceso a datos.</p>
 *
 * @author Zoe García Badiola
 * @version 1.0
 * @see CiudadServiceImpl
 */
public interface CiudadService {

    /**
     * Obtiene todos los registros de {@link Ciudad} en la base de datos.
     * @return lista con todos los registros, vacía si no hay ninguno
     */
    List<Ciudad> getAllCiudads();

    /**
     * Busca un {@link Ciudad} por su ID.
     * @param id identificador del registro
     * @return el registro encontrado
     * @throws RuntimeException si no existe un registro con ese ID
     */
    Ciudad getCiudadById(Long id);

    /**
     * Crea y persiste un nuevo {@link Ciudad} en la base de datos.
     * @param ciudad datos del registro a crear
     * @return el registro creado con su ID asignado
     */
    Ciudad createCiudad(Ciudad ciudad);

    /**
     * Actualiza los datos de un {@link Ciudad} existente.
     * @param id    ID del registro a actualizar
     * @param ciudad nuevos datos del registro
     * @return el registro actualizado
     * @throws RuntimeException si no existe un registro con ese ID
     */
    Ciudad updateCiudad(Long id, Ciudad ciudad);

    /**
     * Elimina un {@link Ciudad} por su ID.
     * @param id identificador del registro a eliminar
     */
    void deleteCiudad(Long id);
}
