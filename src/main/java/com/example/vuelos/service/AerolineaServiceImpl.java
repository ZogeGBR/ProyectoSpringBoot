package com.example.vuelos.service;

import com.example.vuelos.model.Aerolinea;
import com.example.vuelos.repository.AerolineaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AerolineaServiceImpl implements AerolineaService {

    private final AerolineaRepository aerolineaRepository;

    @Autowired
    public AerolineaServiceImpl(AerolineaRepository aerolineaRepository) {
        this.aerolineaRepository = aerolineaRepository;
    }

    @Override
    public List<Aerolinea> getAllAerolineas() {
        return aerolineaRepository.findAll();
    }

    @Override
    public Aerolinea getAerolineaById(Long id) {
        return aerolineaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Aerolinea no encontrada"));
    }

    @Override
    public Aerolinea createAerolinea(Aerolinea aerolinea) {
        return aerolineaRepository.save(aerolinea);
    }

    @Override
    public Aerolinea updateAerolinea(Long id, Aerolinea aerolinea) {
        Aerolinea existing = getAerolineaById(id);
        existing.setNombreAerolinea(aerolinea.getNombreAerolinea());
        return aerolineaRepository.save(existing);
    }

    @Override
    public void deleteAerolinea(Long id) {
        aerolineaRepository.deleteById(id);
    }
}
