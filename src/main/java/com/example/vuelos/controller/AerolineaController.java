package com.example.vuelos.controller;

import com.example.vuelos.model.Aerolinea;
import com.example.vuelos.service.AerolineaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import java.util.List;

/**
 * Controlador REST para la gestión de Aerolinea.
 *
 * <p>Expone los endpoints HTTP para crear, leer, actualizar y eliminar
 * registros de {@link Aerolinea}. Delega toda la lógica al {@link AerolineaService}.</p>
 *
 * <p>Base URL: {@code /api/aerolineas}</p>
 *
 * @author Zoe García Badiola
 * @version 1.0
 * @see AerolineaService
 */
@RestController
@RequestMapping("/api/aerolineas")
public class AerolineaController {

    private final AerolineaService aerolineaService;

    @Autowired
    public AerolineaController(AerolineaService aerolineaService) {
        this.aerolineaService = aerolineaService;
    }

    @GetMapping
    public List<Aerolinea> getAllAerolineas() {
        return aerolineaService.getAllAerolineas();
    }

    @GetMapping("/{id}")
    public Aerolinea getAerolineaById(@PathVariable Long id) {
        return aerolineaService.getAerolineaById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Aerolinea createAerolinea(@Valid @RequestBody Aerolinea aerolinea) {
        return aerolineaService.createAerolinea(aerolinea);
    }

    @PutMapping("/{id}")
    public Aerolinea updateAerolinea(@PathVariable Long id, @Valid @RequestBody Aerolinea aerolinea) {
        return aerolineaService.updateAerolinea(id, aerolinea);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAerolinea(@PathVariable Long id) {
        aerolineaService.deleteAerolinea(id);
    }
}
