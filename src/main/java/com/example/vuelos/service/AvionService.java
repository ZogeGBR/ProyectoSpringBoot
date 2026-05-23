package com.example.vuelos.service;

import com.example.vuelos.model.Avion;
import java.util.List;

public interface AvionService {
    List<Avion> getAllAviones();
    Avion getAvionById(Long id);
    Avion createAvion(Avion avion);
    Avion updateAvion(Long id, Avion avion);
    void deleteAvion(Long id);
}
