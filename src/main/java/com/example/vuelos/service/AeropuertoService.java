package com.example.vuelos.service;

import com.example.vuelos.model.Aeropuerto;
import java.util.List;

public interface AeropuertoService {
    List<Aeropuerto> getAllAeropuertos();
    Aeropuerto getAeropuertoById(Long id);
    Aeropuerto createAeropuerto(Aeropuerto aeropuerto);
    Aeropuerto updateAeropuerto(Long id, Aeropuerto aeropuerto);
    void deleteAeropuerto(Long id);
}
