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

@RestControllerAdvice
public class GlobalExceptionHandler {

    // Errores de validacion (@Valid) - campo invalido, tipo incorrecto, etc.
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

    // JSON malformado (ej: letra donde va un numero)
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

    // Recurso no encontrado
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<Map<String, String>> handleNotFound(RuntimeException ex) {
        Map<String, String> response = new HashMap<>();
        response.put("error", ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    // Violacion de constraint (clave duplicada, etc.)
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
