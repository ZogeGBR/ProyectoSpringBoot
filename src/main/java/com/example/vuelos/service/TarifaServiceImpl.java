package com.example.vuelos.service;

import com.example.vuelos.model.Tarifa;
import com.example.vuelos.model.Vuelo;
import com.example.vuelos.repository.TarifaRepository;
import com.example.vuelos.repository.VueloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TarifaServiceImpl implements TarifaService {

    private final TarifaRepository tarifaRepository;
    private final VueloRepository vueloRepository;

    @Autowired
    public TarifaServiceImpl(TarifaRepository tarifaRepository,
                              VueloRepository vueloRepository) {
        this.tarifaRepository = tarifaRepository;
        this.vueloRepository = vueloRepository;
    }

    @Override
    public List<Tarifa> getAllTarifas() {
        return tarifaRepository.findAll();
    }

    @Override
    public Tarifa getTarifaById(Long id) {
        return tarifaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tarifa no encontrada"));
    }

    private Tarifa resolveRelations(Tarifa tarifa) {
        if (tarifa.getVuelo() != null && tarifa.getVuelo().getId() != null) {
            Vuelo vuelo = vueloRepository.findById(tarifa.getVuelo().getId())
                    .orElseThrow(() -> new RuntimeException("Vuelo no encontrado"));
            tarifa.setVuelo(vuelo);
        }
        return tarifa;
    }

    @Override
    public Tarifa createTarifa(Tarifa tarifa) {
        return tarifaRepository.save(resolveRelations(tarifa));
    }

    @Override
    public Tarifa updateTarifa(Long id, Tarifa tarifa) {
        Tarifa existing = getTarifaById(id);
        existing.setNumeroTarifa(tarifa.getNumeroTarifa());
        existing.setImpuestoTarifa(tarifa.getImpuestoTarifa());
        existing.setPrecioTarifa(tarifa.getPrecioTarifa());
        existing.setClaseTarifa(tarifa.getClaseTarifa());
        resolveRelations(tarifa);
        existing.setVuelo(tarifa.getVuelo());
        return tarifaRepository.save(existing);
    }

    @Override
    public void deleteTarifa(Long id) {
        tarifaRepository.deleteById(id);
    }
}
