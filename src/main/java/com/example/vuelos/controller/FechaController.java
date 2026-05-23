package com.example.vuelos.controller;

import com.example.vuelos.model.Fecha;
import com.example.vuelos.service.FechaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/fechas")
public class FechaController {

    private final FechaService fechaService;

    @Autowired
    public FechaController(FechaService fechaService) {
        this.fechaService = fechaService;
    }

    @GetMapping
    public List<Fecha> getAllFechas() {
        return fechaService.getAllFechas();
    }

    @GetMapping("/{id}")
    public Fecha getFechaById(@PathVariable Long id) {
        return fechaService.getFechaById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Fecha createFecha(@Valid @RequestBody Fecha fecha) {
        return fechaService.createFecha(fecha);
    }

    @PutMapping("/{id}")
    public Fecha updateFecha(@PathVariable Long id, @Valid @RequestBody Fecha fecha) {
        return fechaService.updateFecha(id, fecha);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteFecha(@PathVariable Long id) {
        fechaService.deleteFecha(id);
    }
}
