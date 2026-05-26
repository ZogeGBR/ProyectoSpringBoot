package com.example.vuelos.service;

import com.example.vuelos.model.Asiento;
import java.util.List;

/**
 * Interfaz de servicio para la gestión de {@link Asiento}.
 *
 * <p>Define el contrato de operaciones CRUD que debe implementar
 * {@code AsientoServiceImpl}. Separa la lógica de negocio de
 * los detalles de acceso a datos.</p>
 *
 * @author Zoe García Badiola
 * @version 1.0
 * @see AsientoServiceImpl
 */
public interface AsientoService {

    /**
     * Obtiene todos los registros de {@link Asiento} en la base de datos.
     * @return lista con todos los registros, vacía si no hay ninguno
     */
    List<Asiento> getAllAsientos();

    /**
     * Busca un {@link Asiento} por su ID.
     * @param id identificador del registro
     * @return el registro encontrado
     * @throws RuntimeException si no existe un registro con ese ID
     */
    Asiento getAsientoById(Long id);

    /**
     * Crea y persiste un nuevo {@link Asiento} en la base de datos.
     * @param asiento datos del registro a crear
     * @return el registro creado con su ID asignado
     */
    Asiento createAsiento(Asiento asiento);

    /**
     * Actualiza los datos de un {@link Asiento} existente.
     * @param id    ID del registro a actualizar
     * @param asiento nuevos datos del registro
     * @return el registro actualizado
     * @throws RuntimeException si no existe un registro con ese ID
     */
    Asiento updateAsiento(Long id, Asiento asiento);

    /**
     * Elimina un {@link Asiento} por su ID.
     * @param id identificador del registro a eliminar
     */
    void deleteAsiento(Long id);
}
