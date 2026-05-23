package com.example.vuelos.service;

import com.example.vuelos.model.Ciudad;
import java.util.List;

public interface CiudadService {
    List<Ciudad> getAllCiudades();
    Ciudad getCiudadById(Long id);
    Ciudad createCiudad(Ciudad ciudad);
    Ciudad updateCiudad(Long id, Ciudad ciudad);
    void deleteCiudad(Long id);
}
