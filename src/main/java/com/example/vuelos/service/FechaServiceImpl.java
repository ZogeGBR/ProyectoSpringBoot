package com.example.vuelos.service;

import com.example.vuelos.model.Fecha;
import com.example.vuelos.repository.FechaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class FechaServiceImpl implements FechaService {

    private final FechaRepository fechaRepository;

    @Autowired
    public FechaServiceImpl(FechaRepository fechaRepository) {
        this.fechaRepository = fechaRepository;
    }

    @Override
    public List<Fecha> getAllFechas() {
        return fechaRepository.findAll();
    }

    @Override
    public Fecha getFechaById(Long id) {
        return fechaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Fecha no encontrada"));
    }

    @Override
    public Fecha createFecha(Fecha fecha) {
        return fechaRepository.save(fecha);
    }

    @Override
    public Fecha updateFecha(Long id, Fecha fecha) {
        Fecha existing = getFechaById(id);
        existing.setFecha(fecha.getFecha());
        return fechaRepository.save(existing);
    }

    @Override
    public void deleteFecha(Long id) {
        fechaRepository.deleteById(id);
    }
}
