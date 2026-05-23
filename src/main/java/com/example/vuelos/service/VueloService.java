package com.example.vuelos.service;

import com.example.vuelos.model.Vuelo;
import java.util.List;

public interface VueloService {
    List<Vuelo> getAllVuelos();
    Vuelo getVueloById(Long id);
    Vuelo createVuelo(Vuelo vuelo);
    Vuelo updateVuelo(Long id, Vuelo vuelo);
    void deleteVuelo(Long id);
}
