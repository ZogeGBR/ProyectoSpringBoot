package com.example.vuelos.service;

import com.example.vuelos.model.Consulta;
import java.util.List;

/**
 * Interfaz de servicio para la gestión de {@link Consulta}.
 *
 * <p>Define el contrato de operaciones CRUD que debe implementar
 * {@code ConsultaServiceImpl}. Separa la lógica de negocio de
 * los detalles de acceso a datos.</p>
 *
 * @author Zoe García Badiola
 * @version 1.0
 * @see ConsultaServiceImpl
 */
public interface ConsultaService {

    /**
     * Obtiene todos los registros de {@link Consulta} en la base de datos.
     * @return lista con todos los registros, vacía si no hay ninguno
     */
    List<Consulta> getAllConsultas();

    /**
     * Busca un {@link Consulta} por su ID.
     * @param id identificador del registro
     * @return el registro encontrado
     * @throws RuntimeException si no existe un registro con ese ID
     */
    Consulta getConsultaById(Long id);

    /**
     * Crea y persiste un nuevo {@link Consulta} en la base de datos.
     * @param consulta datos del registro a crear
     * @return el registro creado con su ID asignado
     */
    Consulta createConsulta(Consulta consulta);

    /**
     * Actualiza los datos de un {@link Consulta} existente.
     * @param id    ID del registro a actualizar
     * @param consulta nuevos datos del registro
     * @return el registro actualizado
     * @throws RuntimeException si no existe un registro con ese ID
     */
    Consulta updateConsulta(Long id, Consulta consulta);

    /**
     * Elimina un {@link Consulta} por su ID.
     * @param id identificador del registro a eliminar
     */
    void deleteConsulta(Long id);
}
