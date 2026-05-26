package com.example.vuelos.service;

import com.example.vuelos.model.Aeropuerto;
import com.example.vuelos.model.Ciudad;
import com.example.vuelos.repository.AeropuertoRepository;
import com.example.vuelos.repository.CiudadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AeropuertoServiceImpl implements AeropuertoService {

    private final AeropuertoRepository aeropuertoRepository;
    private final CiudadRepository ciudadRepository;

    @Autowired
    public AeropuertoServiceImpl(AeropuertoRepository aeropuertoRepository,
                                  CiudadRepository ciudadRepository) {
        this.aeropuertoRepository = aeropuertoRepository;
        this.ciudadRepository = ciudadRepository;
    }

    @Override
    public List<Aeropuerto> getAllAeropuertos() {
        return aeropuertoRepository.findAll();
    }

    @Override
    public Aeropuerto getAeropuertoById(Long id) {
        return aeropuertoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Aeropuerto no encontrado"));
    }

    private Aeropuerto resolveRelations(Aeropuerto aeropuerto) {
        if (aeropuerto.getCiudad() != null && aeropuerto.getCiudad().getId() != null) {
            Ciudad ciudad = ciudadRepository.findById(aeropuerto.getCiudad().getId())
                    .orElseThrow(() -> new RuntimeException("Ciudad no encontrada"));
            aeropuerto.setCiudad(ciudad);
        }
        return aeropuerto;
    }

    @Override
    public Aeropuerto createAeropuerto(Aeropuerto aeropuerto) {
        return aeropuertoRepository.save(resolveRelations(aeropuerto));
    }

    @Override
    public Aeropuerto updateAeropuerto(Long id, Aeropuerto aeropuerto) {
        Aeropuerto existing = getAeropuertoById(id);
        existing.setNombreAeropuerto(aeropuerto.getNombreAeropuerto());
        resolveRelations(aeropuerto);
        existing.setCiudad(aeropuerto.getCiudad());
        return aeropuertoRepository.save(existing);
    }

    @Override
    public void deleteAeropuerto(Long id) {
        aeropuertoRepository.deleteById(id);
    }
}
