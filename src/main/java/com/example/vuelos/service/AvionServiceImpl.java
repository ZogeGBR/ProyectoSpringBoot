package com.example.vuelos.service;

import com.example.vuelos.model.Avion;
import com.example.vuelos.repository.AvionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AvionServiceImpl implements AvionService {

    private final AvionRepository avionRepository;

    @Autowired
    public AvionServiceImpl(AvionRepository avionRepository) {
        this.avionRepository = avionRepository;
    }

    @Override
    public List<Avion> getAllAviones() {
        return avionRepository.findAll();
    }

    @Override
    public Avion getAvionById(Long id) {
        return avionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Avion no encontrado"));
    }

    @Override
    public Avion createAvion(Avion avion) {
        return avionRepository.save(avion);
    }

    @Override
    public Avion updateAvion(Long id, Avion avion) {
        Avion existing = getAvionById(id);
        existing.setNumeroAvion(avion.getNumeroAvion());
        return avionRepository.save(existing);
    }

    @Override
    public void deleteAvion(Long id) {
        avionRepository.deleteById(id);
    }
}
