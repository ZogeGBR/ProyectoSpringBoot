package com.example.vuelos.service;

import com.example.vuelos.model.Aerolinea;
import java.util.List;

public interface AerolineaService {
    List<Aerolinea> getAllAerolineas();
    Aerolinea getAerolineaById(Long id);
    Aerolinea createAerolinea(Aerolinea aerolinea);
    Aerolinea updateAerolinea(Long id, Aerolinea aerolinea);
    void deleteAerolinea(Long id);
}
