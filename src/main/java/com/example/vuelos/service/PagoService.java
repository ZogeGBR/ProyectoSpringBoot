package com.example.vuelos.service;

import com.example.vuelos.model.Pago;
import java.util.List;

public interface PagoService {
    List<Pago> getAllPagos();
    Pago getPagoById(Long id);
    Pago createPago(Pago pago);
    Pago updatePago(Long id, Pago pago);
    void deletePago(Long id);
}
