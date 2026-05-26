package com.example.vuelos.service;

import com.example.vuelos.model.Piloto;
import java.util.List;

/**
 * Interfaz de servicio para la gestión de {@link Piloto}.
 *
 * <p>Define el contrato de operaciones CRUD que debe implementar
 * {@code PilotoServiceImpl}. Separa la lógica de negocio de
 * los detalles de acceso a datos.</p>
 *
 * @author Zoe García Badiola
 * @version 1.0
 * @see PilotoServiceImpl
 */
public interface PilotoService {

    /**
     * Obtiene todos los registros de {@link Piloto} en la base de datos.
     * @return lista con todos los registros, vacía si no hay ninguno
     */
    List<Piloto> getAllPilotos();

    /**
     * Busca un {@link Piloto} por su ID.
     * @param id identificador del registro
     * @return el registro encontrado
     * @throws RuntimeException si no existe un registro con ese ID
     */
    Piloto getPilotoById(Long id);

    /**
     * Crea y persiste un nuevo {@link Piloto} en la base de datos.
     * @param piloto datos del registro a crear
     * @return el registro creado con su ID asignado
     */
    Piloto createPiloto(Piloto piloto);

    /**
     * Actualiza los datos de un {@link Piloto} existente.
     * @param id    ID del registro a actualizar
     * @param piloto nuevos datos del registro
     * @return el registro actualizado
     * @throws RuntimeException si no existe un registro con ese ID
     */
    Piloto updatePiloto(Long id, Piloto piloto);

    /**
     * Elimina un {@link Piloto} por su ID.
     * @param id identificador del registro a eliminar
     */
    void deletePiloto(Long id);
}
