package com.example.vuelos.service;

import com.example.vuelos.model.Aerolinea;
import java.util.List;

/**
 * Interfaz de servicio para la gestión de {@link Aerolinea}.
 *
 * <p>Define el contrato de operaciones CRUD que debe implementar
 * {@code AerolineaServiceImpl}. Separa la lógica de negocio de
 * los detalles de acceso a datos.</p>
 *
 * @author Zoe García Badiola
 * @version 1.0
 * @see AerolineaServiceImpl
 */
public interface AerolineaService {

    /**
     * Obtiene todos los registros de {@link Aerolinea} en la base de datos.
     * @return lista con todos los registros, vacía si no hay ninguno
     */
    List<Aerolinea> getAllAerolineas();

    /**
     * Busca un {@link Aerolinea} por su ID.
     * @param id identificador del registro
     * @return el registro encontrado
     * @throws RuntimeException si no existe un registro con ese ID
     */
    Aerolinea getAerolineaById(Long id);

    /**
     * Crea y persiste un nuevo {@link Aerolinea} en la base de datos.
     * @param aerolinea datos del registro a crear
     * @return el registro creado con su ID asignado
     */
    Aerolinea createAerolinea(Aerolinea aerolinea);

    /**
     * Actualiza los datos de un {@link Aerolinea} existente.
     * @param id    ID del registro a actualizar
     * @param aerolinea nuevos datos del registro
     * @return el registro actualizado
     * @throws RuntimeException si no existe un registro con ese ID
     */
    Aerolinea updateAerolinea(Long id, Aerolinea aerolinea);

    /**
     * Elimina un {@link Aerolinea} por su ID.
     * @param id identificador del registro a eliminar
     */
    void deleteAerolinea(Long id);
}
