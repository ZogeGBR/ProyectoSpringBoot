package com.example.vuelos.service;

import com.example.vuelos.model.Usuario;
import java.util.List;

/**
 * Interfaz de servicio para la gestión de {@link Usuario}.
 *
 * <p>Define el contrato de operaciones CRUD que debe implementar
 * {@code UsuarioServiceImpl}. Separa la lógica de negocio de
 * los detalles de acceso a datos.</p>
 *
 * @author Zoe García Badiola
 * @version 1.0
 * @see UsuarioServiceImpl
 */
public interface UsuarioService {

    /**
     * Obtiene todos los registros de {@link Usuario} en la base de datos.
     * @return lista con todos los registros, vacía si no hay ninguno
     */
    List<Usuario> getAllUsuarios();

    /**
     * Busca un {@link Usuario} por su ID.
     * @param id identificador del registro
     * @return el registro encontrado
     * @throws RuntimeException si no existe un registro con ese ID
     */
    Usuario getUsuarioById(Long id);

    /**
     * Crea y persiste un nuevo {@link Usuario} en la base de datos.
     * @param usuario datos del registro a crear
     * @return el registro creado con su ID asignado
     */
    Usuario createUsuario(Usuario usuario);

    /**
     * Actualiza los datos de un {@link Usuario} existente.
     * @param id    ID del registro a actualizar
     * @param usuario nuevos datos del registro
     * @return el registro actualizado
     * @throws RuntimeException si no existe un registro con ese ID
     */
    Usuario updateUsuario(Long id, Usuario usuario);

    /**
     * Elimina un {@link Usuario} por su ID.
     * @param id identificador del registro a eliminar
     */
    void deleteUsuario(Long id);
}
