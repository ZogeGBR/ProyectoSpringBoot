package com.example.vuelos.service;

import com.example.vuelos.model.Fecha;
import java.util.List;

/**
 * Interfaz de servicio para la gestión de {@link Fecha}.
 *
 * <p>Define el contrato de operaciones CRUD que debe implementar
 * {@code FechaServiceImpl}. Separa la lógica de negocio de
 * los detalles de acceso a datos.</p>
 *
 * @author Zoe García Badiola
 * @version 1.0
 * @see FechaServiceImpl
 */
public interface FechaService {

    /**
     * Obtiene todos los registros de {@link Fecha} en la base de datos.
     * @return lista con todos los registros, vacía si no hay ninguno
     */
    List<Fecha> getAllFechas();

    /**
     * Busca un {@link Fecha} por su ID.
     * @param id identificador del registro
     * @return el registro encontrado
     * @throws RuntimeException si no existe un registro con ese ID
     */
    Fecha getFechaById(Long id);

    /**
     * Crea y persiste un nuevo {@link Fecha} en la base de datos.
     * @param fecha datos del registro a crear
     * @return el registro creado con su ID asignado
     */
    Fecha createFecha(Fecha fecha);

    /**
     * Actualiza los datos de un {@link Fecha} existente.
     * @param id    ID del registro a actualizar
     * @param fecha nuevos datos del registro
     * @return el registro actualizado
     * @throws RuntimeException si no existe un registro con ese ID
     */
    Fecha updateFecha(Long id, Fecha fecha);

    /**
     * Elimina un {@link Fecha} por su ID.
     * @param id identificador del registro a eliminar
     */
    void deleteFecha(Long id);
}
