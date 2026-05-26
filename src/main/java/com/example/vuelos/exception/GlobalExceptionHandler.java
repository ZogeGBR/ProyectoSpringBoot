package com.example.vuelos.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

/**
 * Manejador global de excepciones para toda la API REST.
 *
 * <p>Intercepta las excepciones lanzadas por los controladores y las
 * transforma en respuestas HTTP con mensajes de error claros en formato JSON,
 * evitando que el servidor devuelva stack traces al cliente.</p>
 *
 * <p>Tipos de errores manejados:</p>
 * <ul>
 *   <li><b>Validación</b> ({@code @Valid}): HTTP 400 con detalle por campo</li>
 *   <li><b>JSON malformado</b>: HTTP 400 con mensaje descriptivo</li>
 *   <li><b>Recurso no encontrado</b> ({@code RuntimeException}): HTTP 404</li>
 *   <li><b>Clave duplicada</b> ({@code DataIntegrityViolationException}): HTTP 409</li>
 * </ul>
 *
 * @author Zoe García Badiola
 * @version 1.0
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * Maneja errores de validación de campos ({@code @Valid}).
     *
     * <p>Se activa cuando un {@code @RequestBody} no pasa las validaciones
     * definidas con anotaciones como {@code @NotNull}, {@code @Min},
     * {@code @Email}, etc. Devuelve un mapa con el nombre del campo
     * y el mensaje de error correspondiente.</p>
     *
     * @param ex excepción de validación lanzada por Spring
     * @return respuesta HTTP 400 con el detalle de cada campo inválido
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, Object>> handleValidationErrors(MethodArgumentNotValidException ex) {
        Map<String, String> errores = new HashMap<>();
        for (FieldError error : ex.getBindingResult().getFieldErrors()) {
            errores.put(error.getField(), error.getDefaultMessage());
        }
        Map<String, Object> response = new HashMap<>();
        response.put("error", "Datos inválidos");
        response.put("campos", errores);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    /**
     * Maneja errores de JSON malformado o tipos de datos incorrectos.
     *
     * <p>Se activa cuando el cliente envía, por ejemplo, texto donde
     * se espera un número entero, o un JSON con sintaxis inválida.</p>
     *
     * @param ex excepción de lectura del mensaje HTTP
     * @return respuesta HTTP 400 con un mensaje descriptivo del error
     */
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<Map<String, String>> handleBadJson(HttpMessageNotReadableException ex) {
        Map<String, String> response = new HashMap<>();
        String msg = ex.getMessage();
        if (msg != null && msg.contains("int")) {
            response.put("error", "Tipo de dato incorrecto: se esperaba un número entero");
        } else if (msg != null && msg.contains("Cannot deserialize")) {
            response.put("error", "Formato de dato incorrecto en el JSON enviado");
        } else {
            response.put("error", "El JSON enviado tiene formato incorrecto");
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    /**
     * Maneja errores de recurso no encontrado.
     *
     * <p>Se activa cuando un {@code Service} lanza una {@code RuntimeException},
     * típicamente cuando se busca un registro por ID y no existe en la base de datos.</p>
     *
     * @param ex excepción de tiempo de ejecución con el mensaje de error
     * @return respuesta HTTP 404 con el mensaje de la excepción
     */
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<Map<String, String>> handleNotFound(RuntimeException ex) {
        Map<String, String> response = new HashMap<>();
        response.put("error", ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    /**
     * Maneja errores de integridad de datos (claves duplicadas, restricciones únicas).
     *
     * <p>Se activa cuando se intenta insertar un registro con un valor que viola
     * una restricción única de la base de datos, como un correo electrónico
     * ya registrado o un número de tarjeta duplicado.</p>
     *
     * @param ex excepción de violación de integridad referencial
     * @return respuesta HTTP 409 con el detalle del error de base de datos
     */
    @ExceptionHandler(org.springframework.dao.DataIntegrityViolationException.class)
    public ResponseEntity<Map<String, String>> handleDataIntegrity(org.springframework.dao.DataIntegrityViolationException ex) {
        Map<String, String> response = new HashMap<>();
        String msg = ex.getRootCause() != null ? ex.getRootCause().getMessage() : ex.getMessage();
        if (msg != null && msg.contains("Unique index")) {
            response.put("error", "Ya existe un registro con ese valor único (duplicado)");
        } else {
            response.put("error", "Error de integridad de datos: " + msg);
        }
        return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
    }
}
