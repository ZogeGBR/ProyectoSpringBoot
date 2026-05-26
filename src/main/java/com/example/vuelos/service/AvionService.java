package com.example.vuelos.service;

import com.example.vuelos.model.Avion;
import java.util.List;

/**
 * Interfaz de servicio para la gestión de {@link Avion}.
 *
 * <p>Define el contrato de operaciones CRUD que debe implementar
 * {@code AvionServiceImpl}. Separa la lógica de negocio de
 * los detalles de acceso a datos.</p>
 *
 * @author Zoe García Badiola
 * @version 1.0
 * @see AvionServiceImpl
 */
public interface AvionService {

    /**
     * Obtiene todos los registros de {@link Avion} en la base de datos.
     * @return lista con todos los registros, vacía si no hay ninguno
     */
    List<Avion> getAllAvions();

    /**
     * Busca un {@link Avion} por su ID.
     * @param id identificador del registro
     * @return el registro encontrado
     * @throws RuntimeException si no existe un registro con ese ID
     */
    Avion getAvionById(Long id);

    /**
     * Crea y persiste un nuevo {@link Avion} en la base de datos.
     * @param avion datos del registro a crear
     * @return el registro creado con su ID asignado
     */
    Avion createAvion(Avion avion);

    /**
     * Actualiza los datos de un {@link Avion} existente.
     * @param id    ID del registro a actualizar
     * @param avion nuevos datos del registro
     * @return el registro actualizado
     * @throws RuntimeException si no existe un registro con ese ID
     */
    Avion updateAvion(Long id, Avion avion);

    /**
     * Elimina un {@link Avion} por su ID.
     * @param id identificador del registro a eliminar
     */
    void deleteAvion(Long id);
}
