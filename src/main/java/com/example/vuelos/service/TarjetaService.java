package com.example.vuelos.service;

import com.example.vuelos.model.Tarjeta;
import java.util.List;

/**
 * Interfaz de servicio para la gestión de {@link Tarjeta}.
 *
 * <p>Define el contrato de operaciones CRUD que debe implementar
 * {@code TarjetaServiceImpl}. Separa la lógica de negocio de
 * los detalles de acceso a datos.</p>
 *
 * @author Zoe García Badiola
 * @version 1.0
 * @see TarjetaServiceImpl
 */
public interface TarjetaService {

    /**
     * Obtiene todos los registros de {@link Tarjeta} en la base de datos.
     * @return lista con todos los registros, vacía si no hay ninguno
     */
    List<Tarjeta> getAllTarjetas();

    /**
     * Busca un {@link Tarjeta} por su ID.
     * @param id identificador del registro
     * @return el registro encontrado
     * @throws RuntimeException si no existe un registro con ese ID
     */
    Tarjeta getTarjetaById(Long id);

    /**
     * Crea y persiste un nuevo {@link Tarjeta} en la base de datos.
     * @param tarjeta datos del registro a crear
     * @return el registro creado con su ID asignado
     */
    Tarjeta createTarjeta(Tarjeta tarjeta);

    /**
     * Actualiza los datos de un {@link Tarjeta} existente.
     * @param id    ID del registro a actualizar
     * @param tarjeta nuevos datos del registro
     * @return el registro actualizado
     * @throws RuntimeException si no existe un registro con ese ID
     */
    Tarjeta updateTarjeta(Long id, Tarjeta tarjeta);

    /**
     * Elimina un {@link Tarjeta} por su ID.
     * @param id identificador del registro a eliminar
     */
    void deleteTarjeta(Long id);
}
