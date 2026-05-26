package com.example.vuelos.controller;

import com.example.vuelos.model.Avion;
import com.example.vuelos.service.AvionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import java.util.List;

/**
 * Controlador REST para la gestión de Avion.
 *
 * <p>Expone los endpoints HTTP para crear, leer, actualizar y eliminar
 * registros de {@link Avion}. Delega toda la lógica al {@link AvionService}.</p>
 *
 * <p>Base URL: {@code /api/aviones}</p>
 *
 * @author Zoe García Badiola
 * @version 1.0
 * @see AvionService
 */
@RestController
@RequestMapping("/api/aviones")
public class AvionController {

    private final AvionService avionService;

    @Autowired
    public AvionController(AvionService avionService) {
        this.avionService = avionService;
    }

    @GetMapping
    public List<Avion> getAllAviones() {
        return avionService.getAllAviones();
    }

    @GetMapping("/{id}")
    public Avion getAvionById(@PathVariable Long id) {
        return avionService.getAvionById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Avion createAvion(@Valid @RequestBody Avion avion) {
        return avionService.createAvion(avion);
    }

    @PutMapping("/{id}")
    public Avion updateAvion(@PathVariable Long id, @Valid @RequestBody Avion avion) {
        return avionService.updateAvion(id, avion);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAvion(@PathVariable Long id) {
        avionService.deleteAvion(id);
    }
}
