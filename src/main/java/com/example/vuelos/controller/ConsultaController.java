package com.example.vuelos.controller;

import com.example.vuelos.model.Consulta;
import com.example.vuelos.service.ConsultaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.util.List;

/**
 * Controlador REST para la gestión de Consulta.
 *
 * <p>Expone los endpoints HTTP para crear, leer, actualizar y eliminar
 * registros de {@link Consulta}. Delega toda la lógica al {@link ConsultaService}.</p>
 *
 * <p>Base URL: {@code /api/consultas}</p>
 *
 * @author Zoe García Badiola
 * @version 1.0
 * @see ConsultaService
 */
@RestController
@RequestMapping("/api/consultas")
public class ConsultaController {

    private final ConsultaService updateConsultaService;

    @Autowired
    public ConsultaController(ConsultaService updateConsultaService) {
        this.updateConsultaService = updateConsultaService;
    }

    @GetMapping
    public List<Consulta> getAllConsultas() {
        return updateConsultaService.getAllConsultas();
    }

    @GetMapping("/{id}")
    public Consulta getConsultaById(@PathVariable Long id) {
        return updateConsultaService.getConsultaById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Consulta createConsulta(@Valid @RequestBody Consulta updateConsulta) {
        return updateConsultaService.createConsulta(updateConsulta);
    }

    @PutMapping("/{id}")
    public Consulta updateConsulta(@PathVariable Long id, @Valid @RequestBody Consulta updateConsulta) {
        return updateConsultaService.updateConsulta(id, updateConsulta);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteConsulta(@PathVariable Long id) {
        updateConsultaService.deleteConsulta(id);
    }
}
