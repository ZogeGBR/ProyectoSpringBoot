package com.example.vuelos.controller;

import com.example.vuelos.model.Ciudad;
import com.example.vuelos.service.CiudadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/ciudades")
public class CiudadController {

    private final CiudadService ciudadService;

    @Autowired
    public CiudadController(CiudadService ciudadService) {
        this.ciudadService = ciudadService;
    }

    @GetMapping
    public List<Ciudad> getAllCiudades() {
        return ciudadService.getAllCiudades();
    }

    @GetMapping("/{id}")
    public Ciudad getCiudadById(@PathVariable Long id) {
        return ciudadService.getCiudadById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Ciudad createCiudad(@Valid @RequestBody Ciudad ciudad) {
        return ciudadService.createCiudad(ciudad);
    }

    @PutMapping("/{id}")
    public Ciudad updateCiudad(@PathVariable Long id, @Valid @RequestBody Ciudad ciudad) {
        return ciudadService.updateCiudad(id, ciudad);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCiudad(@PathVariable Long id) {
        ciudadService.deleteCiudad(id);
    }
}
