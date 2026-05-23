package com.example.vuelos.controller;

import com.example.vuelos.model.Tarjeta;
import com.example.vuelos.service.TarjetaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/tarjetas")
public class TarjetaController {

    private final TarjetaService updateTarjetaService;

    @Autowired
    public TarjetaController(TarjetaService updateTarjetaService) {
        this.updateTarjetaService = updateTarjetaService;
    }

    @GetMapping
    public List<Tarjeta> getAllTarjetas() {
        return updateTarjetaService.getAllTarjetas();
    }

    @GetMapping("/{id}")
    public Tarjeta getTarjetaById(@PathVariable Long id) {
        return updateTarjetaService.getTarjetaById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Tarjeta createTarjeta(@Valid @RequestBody Tarjeta updateTarjeta) {
        return updateTarjetaService.createTarjeta(updateTarjeta);
    }

    @PutMapping("/{id}")
    public Tarjeta updateTarjeta(@PathVariable Long id, @Valid @RequestBody Tarjeta updateTarjeta) {
        return updateTarjetaService.updateTarjeta(id, updateTarjeta);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTarjeta(@PathVariable Long id) {
        updateTarjetaService.deleteTarjeta(id);
    }
}
