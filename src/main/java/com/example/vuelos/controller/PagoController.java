package com.example.vuelos.controller;

import com.example.vuelos.model.Pago;
import com.example.vuelos.service.PagoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.util.List;

/**
 * Controlador REST para la gestión de Pago.
 *
 * <p>Expone los endpoints HTTP para crear, leer, actualizar y eliminar
 * registros de {@link Pago}. Delega toda la lógica al {@link PagoService}.</p>
 *
 * <p>Base URL: {@code /api/pagos}</p>
 *
 * @author Zoe García Badiola
 * @version 1.0
 * @see PagoService
 */
@RestController
@RequestMapping("/api/pagos")
public class PagoController {

    private final PagoService updatePagoService;

    @Autowired
    public PagoController(PagoService updatePagoService) {
        this.updatePagoService = updatePagoService;
    }

    @GetMapping
    public List<Pago> getAllPagos() {
        return updatePagoService.getAllPagos();
    }

    @GetMapping("/{id}")
    public Pago getPagoById(@PathVariable Long id) {
        return updatePagoService.getPagoById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Pago createPago(@Valid @RequestBody Pago updatePago) {
        return updatePagoService.createPago(updatePago);
    }

    @PutMapping("/{id}")
    public Pago updatePago(@PathVariable Long id, @Valid @RequestBody Pago updatePago) {
        return updatePagoService.updatePago(id, updatePago);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePago(@PathVariable Long id) {
        updatePagoService.deletePago(id);
    }
}
