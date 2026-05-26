package com.example.vuelos.service;

import com.example.vuelos.model.Pago;
import java.util.List;

/**
 * Interfaz de servicio para la gestión de {@link Pago}.
 *
 * <p>Define el contrato de operaciones CRUD que debe implementar
 * {@code PagoServiceImpl}. Separa la lógica de negocio de
 * los detalles de acceso a datos.</p>
 *
 * @author Zoe García Badiola
 * @version 1.0
 * @see PagoServiceImpl
 */
public interface PagoService {

    /**
     * Obtiene todos los registros de {@link Pago} en la base de datos.
     * @return lista con todos los registros, vacía si no hay ninguno
     */
    List<Pago> getAllPagos();

    /**
     * Busca un {@link Pago} por su ID.
     * @param id identificador del registro
     * @return el registro encontrado
     * @throws RuntimeException si no existe un registro con ese ID
     */
    Pago getPagoById(Long id);

    /**
     * Crea y persiste un nuevo {@link Pago} en la base de datos.
     * @param pago datos del registro a crear
     * @return el registro creado con su ID asignado
     */
    Pago createPago(Pago pago);

    /**
     * Actualiza los datos de un {@link Pago} existente.
     * @param id    ID del registro a actualizar
     * @param pago nuevos datos del registro
     * @return el registro actualizado
     * @throws RuntimeException si no existe un registro con ese ID
     */
    Pago updatePago(Long id, Pago pago);

    /**
     * Elimina un {@link Pago} por su ID.
     * @param id identificador del registro a eliminar
     */
    void deletePago(Long id);
}
