package com.example.vuelos.service;

import com.example.vuelos.model.Piloto;
import java.util.List;

public interface PilotoService {
    List<Piloto> getAllPilotos();
    Piloto getPilotoById(Long id);
    Piloto createPiloto(Piloto piloto);
    Piloto updatePiloto(Long id, Piloto piloto);
    void deletePiloto(Long id);
}
