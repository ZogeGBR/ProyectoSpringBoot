package com.example.vuelos.service;

import com.example.vuelos.model.Piloto;
import com.example.vuelos.repository.PilotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PilotoServiceImpl implements PilotoService {

    private final PilotoRepository pilotoRepository;

    @Autowired
    public PilotoServiceImpl(PilotoRepository pilotoRepository) {
        this.pilotoRepository = pilotoRepository;
    }

    @Override
    public List<Piloto> getAllPilotos() {
        return pilotoRepository.findAll();
    }

    @Override
    public Piloto getPilotoById(Long id) {
        return pilotoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Piloto no encontrado"));
    }

    @Override
    public Piloto createPiloto(Piloto piloto) {
        return pilotoRepository.save(piloto);
    }

    @Override
    public Piloto updatePiloto(Long id, Piloto piloto) {
        Piloto existing = getPilotoById(id);
        existing.setNumeroPiloto(piloto.getNumeroPiloto());
        existing.setDniPersona(piloto.getDniPersona());
        existing.setNombrePersona(piloto.getNombrePersona());
        existing.setApellidoPersona(piloto.getApellidoPersona());
        return pilotoRepository.save(existing);
    }

    @Override
    public void deletePiloto(Long id) {
        pilotoRepository.deleteById(id);
    }
}
