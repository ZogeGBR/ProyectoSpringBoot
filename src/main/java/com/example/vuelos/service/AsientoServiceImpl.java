package com.example.vuelos.service;

import com.example.vuelos.model.Asiento;
import com.example.vuelos.model.Avion;
import com.example.vuelos.repository.AsientoRepository;
import com.example.vuelos.repository.AvionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AsientoServiceImpl implements AsientoService {

    private final AsientoRepository asientoRepository;
    private final AvionRepository avionRepository;

    @Autowired
    public AsientoServiceImpl(AsientoRepository asientoRepository,
                               AvionRepository avionRepository) {
        this.asientoRepository = asientoRepository;
        this.avionRepository = avionRepository;
    }

    @Override
    public List<Asiento> getAllAsientos() {
        return asientoRepository.findAll();
    }

    @Override
    public Asiento getAsientoById(Long id) {
        return asientoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Asiento no encontrado"));
    }

    private Asiento resolveRelations(Asiento asiento) {
        if (asiento.getAvion() != null && asiento.getAvion().getId() != null) {
            Avion avion = avionRepository.findById(asiento.getAvion().getId())
                    .orElseThrow(() -> new RuntimeException("Avión no encontrado"));
            asiento.setAvion(avion);
        }
        return asiento;
    }

    @Override
    public Asiento createAsiento(Asiento asiento) {
        return asientoRepository.save(resolveRelations(asiento));
    }

    @Override
    public Asiento updateAsiento(Long id, Asiento asiento) {
        Asiento existing = getAsientoById(id);
        existing.setFilaAsiento(asiento.getFilaAsiento());
        existing.setLetraAsiento(asiento.getLetraAsiento());
        existing.setClaseAsiento(asiento.getClaseAsiento());
        resolveRelations(asiento);
        existing.setAvion(asiento.getAvion());
        return asientoRepository.save(existing);
    }

    @Override
    public void deleteAsiento(Long id) {
        asientoRepository.deleteById(id);
    }
}
