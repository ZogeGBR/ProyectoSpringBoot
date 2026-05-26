package com.example.vuelos.controller;

import com.example.vuelos.model.Aeropuerto;
import com.example.vuelos.service.AeropuertoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import java.util.List;

/**
 * Controlador REST para la gestión de Aeropuerto.
 *
 * <p>Expone los endpoints HTTP para crear, leer, actualizar y eliminar
 * registros de {@link Aeropuerto}. Delega toda la lógica al {@link AeropuertoService}.</p>
 *
 * <p>Base URL: {@code /api/aeropuertos}</p>
 *
 * @author Zoe García Badiola
 * @version 1.0
 * @see AeropuertoService
 */
@RestController
@RequestMapping("/api/aeropuertos")
public class AeropuertoController {

    private final AeropuertoService aeropuertoService;

    @Autowired
    public AeropuertoController(AeropuertoService aeropuertoService) {
        this.aeropuertoService = aeropuertoService;
    }

    @GetMapping
    public List<Aeropuerto> getAllAeropuertos() {
        return aeropuertoService.getAllAeropuertos();
    }

    @GetMapping("/{id}")
    public Aeropuerto getAeropuertoById(@PathVariable Long id) {
        return aeropuertoService.getAeropuertoById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Aeropuerto createAeropuerto(@Valid @RequestBody Aeropuerto aeropuerto) {
        return aeropuertoService.createAeropuerto(aeropuerto);
    }

    @PutMapping("/{id}")
    public Aeropuerto updateAeropuerto(@PathVariable Long id, @Valid @RequestBody Aeropuerto aeropuerto) {
        return aeropuertoService.updateAeropuerto(id, aeropuerto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAeropuerto(@PathVariable Long id) {
        aeropuertoService.deleteAeropuerto(id);
    }
}
