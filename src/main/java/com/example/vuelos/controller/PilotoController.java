package com.example.vuelos.controller;

import com.example.vuelos.model.Piloto;
import com.example.vuelos.service.PilotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import java.util.List;

/**
 * Controlador REST para la gestión de Piloto.
 *
 * <p>Expone los endpoints HTTP para crear, leer, actualizar y eliminar
 * registros de {@link Piloto}. Delega toda la lógica al {@link PilotoService}.</p>
 *
 * <p>Base URL: {@code /api/pilotos}</p>
 *
 * @author Zoe García Badiola
 * @version 1.0
 * @see PilotoService
 */
@RestController
@RequestMapping("/api/pilotos")
public class PilotoController {

    private final PilotoService pilotoService;

    @Autowired
    public PilotoController(PilotoService pilotoService) {
        this.pilotoService = pilotoService;
    }

    @GetMapping
    public List<Piloto> getAllPilotos() {
        return pilotoService.getAllPilotos();
    }

    @GetMapping("/{id}")
    public Piloto getPilotoById(@PathVariable Long id) {
        return pilotoService.getPilotoById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Piloto createPiloto(@Valid @RequestBody Piloto piloto) {
        return pilotoService.createPiloto(piloto);
    }

    @PutMapping("/{id}")
    public Piloto updatePiloto(@PathVariable Long id, @Valid @RequestBody Piloto piloto) {
        return pilotoService.updatePiloto(id, piloto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePiloto(@PathVariable Long id) {
        pilotoService.deletePiloto(id);
    }
}
