package com.example.vuelos.service;

import com.example.vuelos.model.Asiento;
import java.util.List;

public interface AsientoService {
    List<Asiento> getAllAsientos();
    Asiento getAsientoById(Long id);
    Asiento createAsiento(Asiento asiento);
    Asiento updateAsiento(Long id, Asiento asiento);
    void deleteAsiento(Long id);
}
