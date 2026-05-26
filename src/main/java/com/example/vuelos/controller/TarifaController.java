package com.example.vuelos.controller;

import com.example.vuelos.model.Tarifa;
import com.example.vuelos.service.TarifaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.util.List;

/**
 * Controlador REST para la gestión de Tarifa.
 *
 * <p>Expone los endpoints HTTP para crear, leer, actualizar y eliminar
 * registros de {@link Tarifa}. Delega toda la lógica al {@link TarifaService}.</p>
 *
 * <p>Base URL: {@code /api/tarifas}</p>
 *
 * @author Zoe García Badiola
 * @version 1.0
 * @see TarifaService
 */
@RestController
@RequestMapping("/api/tarifas")
public class TarifaController {

    private final TarifaService updateTarifaService;

    @Autowired
    public TarifaController(TarifaService updateTarifaService) {
        this.updateTarifaService = updateTarifaService;
    }

    @GetMapping
    public List<Tarifa> getAllTarifas() {
        return updateTarifaService.getAllTarifas();
    }

    @GetMapping("/{id}")
    public Tarifa getTarifaById(@PathVariable Long id) {
        return updateTarifaService.getTarifaById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Tarifa createTarifa(@Valid @RequestBody Tarifa updateTarifa) {
        return updateTarifaService.createTarifa(updateTarifa);
    }

    @PutMapping("/{id}")
    public Tarifa updateTarifa(@PathVariable Long id, @Valid @RequestBody Tarifa updateTarifa) {
        return updateTarifaService.updateTarifa(id, updateTarifa);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTarifa(@PathVariable Long id) {
        updateTarifaService.deleteTarifa(id);
    }
}
