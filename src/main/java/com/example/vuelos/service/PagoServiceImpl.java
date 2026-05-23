package com.example.vuelos.service;

import com.example.vuelos.model.Pago;
import com.example.vuelos.repository.PagoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PagoServiceImpl implements PagoService {

    private final PagoRepository pagoRepository;

    @Autowired
    public PagoServiceImpl(PagoRepository pagoRepository) {
        this.pagoRepository = pagoRepository;
    }

    @Override
    public List<Pago> getAllPagos() {
        return pagoRepository.findAll();
    }

    @Override
    public Pago getPagoById(Long id) {
        return pagoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pago no encontrado"));
    }

    @Override
    public Pago createPago(Pago pago) {
        return pagoRepository.save(pago);
    }

    @Override
    public Pago updatePago(Long id, Pago pago) {
        Pago existing = getPagoById(id);
        existing.setNumeroPago(pago.getNumeroPago());
        existing.setCantidadPago(pago.getCantidadPago());
        return pagoRepository.save(existing);
    }

    @Override
    public void deletePago(Long id) {
        pagoRepository.deleteById(id);
    }
}
