package com.example.vuelos.service;

import com.example.vuelos.model.Ciudad;
import com.example.vuelos.repository.CiudadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CiudadServiceImpl implements CiudadService {

    private final CiudadRepository ciudadRepository;

    @Autowired
    public CiudadServiceImpl(CiudadRepository ciudadRepository) {
        this.ciudadRepository = ciudadRepository;
    }

    @Override
    public List<Ciudad> getAllCiudades() {
        return ciudadRepository.findAll();
    }

    @Override
    public Ciudad getCiudadById(Long id) {
        return ciudadRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ciudad no encontrada"));
    }

    @Override
    public Ciudad createCiudad(Ciudad ciudad) {
        return ciudadRepository.save(ciudad);
    }

    @Override
    public Ciudad updateCiudad(Long id, Ciudad ciudad) {
        Ciudad existing = getCiudadById(id);
        existing.setNombreCiudad(ciudad.getNombreCiudad());
        return ciudadRepository.save(existing);
    }

    @Override
    public void deleteCiudad(Long id) {
        ciudadRepository.deleteById(id);
    }
}
