package com.example.vuelos.service;

import com.example.vuelos.model.Tarifa;
import java.util.List;

public interface TarifaService {
    List<Tarifa> getAllTarifas();
    Tarifa getTarifaById(Long id);
    Tarifa createTarifa(Tarifa tarifa);
    Tarifa updateTarifa(Long id, Tarifa tarifa);
    void deleteTarifa(Long id);
}
