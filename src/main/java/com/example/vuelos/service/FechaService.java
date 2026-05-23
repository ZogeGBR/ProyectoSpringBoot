package com.example.vuelos.service;

import com.example.vuelos.model.Fecha;
import java.util.List;

public interface FechaService {
    List<Fecha> getAllFechas();
    Fecha getFechaById(Long id);
    Fecha createFecha(Fecha fecha);
    Fecha updateFecha(Long id, Fecha fecha);
    void deleteFecha(Long id);
}
