package com.example.vuelos.service;

import com.example.vuelos.model.Aeropuerto;
import java.util.List;

/**
 * Interfaz de servicio para la gestión de {@link Aeropuerto}.
 *
 * <p>Define el contrato de operaciones CRUD que debe implementar
 * {@code AeropuertoServiceImpl}. Separa la lógica de negocio de
 * los detalles de acceso a datos.</p>
 *
 * @author Zoe García Badiola
 * @version 1.0
 * @see AeropuertoServiceImpl
 */
public interface AeropuertoService {

    /**
     * Obtiene todos los registros de {@link Aeropuerto} en la base de datos.
     * @return lista con todos los registros, vacía si no hay ninguno
     */
    List<Aeropuerto> getAllAeropuertos();

    /**
     * Busca un {@link Aeropuerto} por su ID.
     * @param id identificador del registro
     * @return el registro encontrado
     * @throws RuntimeException si no existe un registro con ese ID
     */
    Aeropuerto getAeropuertoById(Long id);

    /**
     * Crea y persiste un nuevo {@link Aeropuerto} en la base de datos.
     * @param aeropuerto datos del registro a crear
     * @return el registro creado con su ID asignado
     */
    Aeropuerto createAeropuerto(Aeropuerto aeropuerto);

    /**
     * Actualiza los datos de un {@link Aeropuerto} existente.
     * @param id    ID del registro a actualizar
     * @param aeropuerto nuevos datos del registro
     * @return el registro actualizado
     * @throws RuntimeException si no existe un registro con ese ID
     */
    Aeropuerto updateAeropuerto(Long id, Aeropuerto aeropuerto);

    /**
     * Elimina un {@link Aeropuerto} por su ID.
     * @param id identificador del registro a eliminar
     */
    void deleteAeropuerto(Long id);
}
