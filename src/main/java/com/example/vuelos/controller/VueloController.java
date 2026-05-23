package com.example.vuelos.controller;

import com.example.vuelos.model.Vuelo;
import com.example.vuelos.service.VueloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/api/vuelos")
public class VueloController {

    private final VueloService vueloService;

    @Autowired
    public VueloController(VueloService vueloService) {
        this.vueloService = vueloService;
    }

    @GetMapping
    public List<Vuelo> getAllVuelos() {
        return vueloService.getAllVuelos();
    }

    @GetMapping("/{id}")
    public Vuelo getVueloById(@PathVariable Long id) {
        return vueloService.getVueloById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Vuelo createVuelo(@Valid @RequestBody Vuelo vuelo) {
        return vueloService.createVuelo(vuelo);
    }

    @PutMapping("/{id}")
    public Vuelo updateVuelo(@PathVariable Long id, @Valid @RequestBody Vuelo vuelo) {
        return vueloService.updateVuelo(id, vuelo);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteVuelo(@PathVariable Long id) {
        vueloService.deleteVuelo(id);
    }
}
