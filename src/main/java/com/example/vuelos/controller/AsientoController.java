package com.example.vuelos.controller;

import com.example.vuelos.model.Asiento;
import com.example.vuelos.service.AsientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.util.List;

/**
 * Controlador REST para la gestión de Asiento.
 *
 * <p>Expone los endpoints HTTP para crear, leer, actualizar y eliminar
 * registros de {@link Asiento}. Delega toda la lógica al {@link AsientoService}.</p>
 *
 * <p>Base URL: {@code /api/asientos}</p>
 *
 * @author Zoe García Badiola
 * @version 1.0
 * @see AsientoService
 */
@RestController
@RequestMapping("/api/asientos")
public class AsientoController {

    private final AsientoService updateAsientoService;

    @Autowired
    public AsientoController(AsientoService updateAsientoService) {
        this.updateAsientoService = updateAsientoService;
    }

    @GetMapping
    public List<Asiento> getAllAsientos() {
        return updateAsientoService.getAllAsientos();
    }

    @GetMapping("/{id}")
    public Asiento getAsientoById(@PathVariable Long id) {
        return updateAsientoService.getAsientoById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Asiento createAsiento(@Valid @RequestBody Asiento updateAsiento) {
        return updateAsientoService.createAsiento(updateAsiento);
    }

    @PutMapping("/{id}")
    public Asiento updateAsiento(@PathVariable Long id, @Valid @RequestBody Asiento updateAsiento) {
        return updateAsientoService.updateAsiento(id, updateAsiento);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAsiento(@PathVariable Long id) {
        updateAsientoService.deleteAsiento(id);
    }
}
