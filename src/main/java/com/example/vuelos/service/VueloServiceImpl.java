package com.example.vuelos.service;

import com.example.vuelos.model.*;
import com.example.vuelos.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class VueloServiceImpl implements VueloService {

    private final VueloRepository vueloRepository;
    private final AerolineaRepository aerolineaRepository;
    private final AvionRepository avionRepository;
    private final PilotoRepository pilotoRepository;
    private final FechaRepository fechaRepository;

    @Autowired
    public VueloServiceImpl(VueloRepository vueloRepository,
                             AerolineaRepository aerolineaRepository,
                             AvionRepository avionRepository,
                             PilotoRepository pilotoRepository,
                             FechaRepository fechaRepository) {
        this.vueloRepository = vueloRepository;
        this.aerolineaRepository = aerolineaRepository;
        this.avionRepository = avionRepository;
        this.pilotoRepository = pilotoRepository;
        this.fechaRepository = fechaRepository;
    }

    @Override
    public List<Vuelo> getAllVuelos() {
        return vueloRepository.findAll();
    }

    @Override
    public Vuelo getVueloById(Long id) {
        return vueloRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Vuelo no encontrado"));
    }

    private Vuelo resolveRelations(Vuelo vuelo) {
        if (vuelo.getAerolinea() != null && vuelo.getAerolinea().getId() != null) {
            vuelo.setAerolinea(aerolineaRepository.findById(vuelo.getAerolinea().getId())
                    .orElseThrow(() -> new RuntimeException("Aerolínea no encontrada")));
        }
        if (vuelo.getAvion() != null && vuelo.getAvion().getId() != null) {
            vuelo.setAvion(avionRepository.findById(vuelo.getAvion().getId())
                    .orElseThrow(() -> new RuntimeException("Avión no encontrado")));
        }
        if (vuelo.getPiloto() != null && vuelo.getPiloto().getId() != null) {
            vuelo.setPiloto(pilotoRepository.findById(vuelo.getPiloto().getId())
                    .orElseThrow(() -> new RuntimeException("Piloto no encontrado")));
        }
        if (vuelo.getSalida() != null && vuelo.getSalida().getId() != null) {
            vuelo.setSalida(fechaRepository.findById(vuelo.getSalida().getId())
                    .orElseThrow(() -> new RuntimeException("Fecha de salida no encontrada")));
        }
        if (vuelo.getDestino() != null && vuelo.getDestino().getId() != null) {
            vuelo.setDestino(fechaRepository.findById(vuelo.getDestino().getId())
                    .orElseThrow(() -> new RuntimeException("Fecha de destino no encontrada")));
        }
        return vuelo;
    }

    @Override
    public Vuelo createVuelo(Vuelo vuelo) {
        return vueloRepository.save(resolveRelations(vuelo));
    }

    @Override
    public Vuelo updateVuelo(Long id, Vuelo vuelo) {
        Vuelo existing = getVueloById(id);
        existing.setNumeroVuelo(vuelo.getNumeroVuelo());
        resolveRelations(vuelo);
        existing.setAerolinea(vuelo.getAerolinea());
        existing.setAvion(vuelo.getAvion());
        existing.setPiloto(vuelo.getPiloto());
        existing.setSalida(vuelo.getSalida());
        existing.setDestino(vuelo.getDestino());
        return vueloRepository.save(existing);
    }

    @Override
    public void deleteVuelo(Long id) {
        vueloRepository.deleteById(id);
    }
}
