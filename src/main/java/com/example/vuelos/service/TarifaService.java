package com.example.vuelos.service;

import com.example.vuelos.model.Tarifa;
import java.util.List;

/**
 * Interfaz de servicio para la gestión de {@link Tarifa}.
 *
 * <p>Define el contrato de operaciones CRUD que debe implementar
 * {@code TarifaServiceImpl}. Separa la lógica de negocio de
 * los detalles de acceso a datos.</p>
 *
 * @author Zoe García Badiola
 * @version 1.0
 * @see TarifaServiceImpl
 */
public interface TarifaService {

    /**
     * Obtiene todos los registros de {@link Tarifa} en la base de datos.
     * @return lista con todos los registros, vacía si no hay ninguno
     */
    List<Tarifa> getAllTarifas();

    /**
     * Busca un {@link Tarifa} por su ID.
     * @param id identificador del registro
     * @return el registro encontrado
     * @throws RuntimeException si no existe un registro con ese ID
     */
    Tarifa getTarifaById(Long id);

    /**
     * Crea y persiste un nuevo {@link Tarifa} en la base de datos.
     * @param tarifa datos del registro a crear
     * @return el registro creado con su ID asignado
     */
    Tarifa createTarifa(Tarifa tarifa);

    /**
     * Actualiza los datos de un {@link Tarifa} existente.
     * @param id    ID del registro a actualizar
     * @param tarifa nuevos datos del registro
     * @return el registro actualizado
     * @throws RuntimeException si no existe un registro con ese ID
     */
    Tarifa updateTarifa(Long id, Tarifa tarifa);

    /**
     * Elimina un {@link Tarifa} por su ID.
     * @param id identificador del registro a eliminar
     */
    void deleteTarifa(Long id);
}
