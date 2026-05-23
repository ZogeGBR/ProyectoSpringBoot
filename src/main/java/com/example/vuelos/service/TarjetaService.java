package com.example.vuelos.service;

import com.example.vuelos.model.Tarjeta;
import java.util.List;

public interface TarjetaService {
    List<Tarjeta> getAllTarjetas();
    Tarjeta getTarjetaById(Long id);
    Tarjeta createTarjeta(Tarjeta tarjeta);
    Tarjeta updateTarjeta(Long id, Tarjeta tarjeta);
    void deleteTarjeta(Long id);
}
