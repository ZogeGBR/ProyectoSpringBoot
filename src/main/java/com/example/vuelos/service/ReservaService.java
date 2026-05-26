package com.example.vuelos.service;

import com.example.vuelos.model.Reserva;
import java.util.List;

/**
 * Interfaz de servicio para la gestión de {@link Reserva}.
 *
 * <p>Define el contrato de operaciones CRUD implementado por
 * {@link ReservaServiceImpl}. La capa Service resuelve las entidades
 * relacionadas (vuelo, usuario, pago) antes de persistir,
 * evitando errores de Hibernate con entidades "detached".</p>
 *
 * @author Zoe García Badiola
 * @version 1.0
 * @see ReservaServiceImpl
 */
public interface ReservaService {

    /**
     * Obtiene todas las reservas registradas en el sistema.
     * @return lista con todas las reservas, vacía si no hay ninguna
     */
    List<Reserva> getAllReservas();

    /**
     * Busca una reserva por su ID interno.
     * @param id identificador de la reserva
     * @return la reserva encontrada
     * @throws RuntimeException si no existe una reserva con ese ID
     */
    Reserva getReservaById(Long id);

    /**
     * Crea y persiste una nueva reserva en la base de datos.
     * Resuelve automáticamente las referencias a vuelo, usuario y pago.
     * @param reserva datos de la reserva a crear
     * @return la reserva creada con su ID asignado
     */
    Reserva createReserva(Reserva reserva);

    /**
     * Actualiza los datos de una reserva existente.
     * @param id      ID de la reserva a actualizar
     * @param reserva nuevos datos de la reserva
     * @return la reserva actualizada
     * @throws RuntimeException si no existe una reserva con ese ID
     */
    Reserva updateReserva(Long id, Reserva reserva);

    /**
     * Elimina una reserva por su ID.
     * @param id identificador de la reserva a eliminar
     */
    void deleteReserva(Long id);
}
