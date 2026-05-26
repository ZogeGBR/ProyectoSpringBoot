package com.example.vuelos.service;

import com.example.vuelos.model.*;
import com.example.vuelos.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * Implementación del servicio de gestión de vuelos.
 *
 * <p>Contiene la lógica de negocio para operaciones CRUD sobre la entidad
 * {@link Vuelo}. Antes de persistir, resuelve todas las entidades relacionadas
 * ({@link Aerolinea}, {@link Avion}, {@link Piloto}, {@link Fecha}) desde la
 * base de datos para evitar el error de Hibernate
 * {@code "detached entity passed to persist"}.</p>
 *
 * <p>Este error ocurre cuando Hibernate recibe un objeto con ID (por ejemplo
 * {@code {"avion": {"id": 1}}}) que no está adjunto a la sesión actual.
 * La solución es cargar el objeto completo con {@code findById()} antes de usarlo.</p>
 *
 * @author Zoe García Badiola
 * @version 1.0
 * @see VueloService
 * @see VueloRepository
 */
@Service
public class VueloServiceImpl implements VueloService {

    /** Repositorio principal para operaciones CRUD de vuelos. */
    private final VueloRepository vueloRepository;
    /** Repositorio para resolver la aerolínea por ID. */
    private final AerolineaRepository aerolineaRepository;
    /** Repositorio para resolver el avión por ID. */
    private final AvionRepository avionRepository;
    /** Repositorio para resolver el piloto por ID. */
    private final PilotoRepository pilotoRepository;
    /** Repositorio para resolver las fechas de salida y destino. */
    private final FechaRepository fechaRepository;

    /**
     * Constructor con inyección de dependencias por constructor.
     * Spring inyecta automáticamente todos los repositorios necesarios.
     *
     * @param vueloRepository      repositorio de vuelos
     * @param aerolineaRepository  repositorio de aerolíneas
     * @param avionRepository      repositorio de aviones
     * @param pilotoRepository     repositorio de pilotos
     * @param fechaRepository      repositorio de fechas
     */
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

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Vuelo> getAllVuelos() {
        return vueloRepository.findAll();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Vuelo getVueloById(Long id) {
        return vueloRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Vuelo no encontrado"));
    }

    /**
     * Resuelve las entidades relacionadas del vuelo desde la base de datos.
     *
     * <p>El frontend envía solo los IDs de las relaciones (ej: {@code {"avion": {"id": 1}}}).
     * Hibernate necesita objetos "managed" completos para hacer el INSERT correctamente.
     * Este método carga cada entidad relacionada antes de persistir el vuelo.</p>
     *
     * @param vuelo vuelo con referencias parciales (solo ID)
     * @return el mismo vuelo con todas las referencias completamente resueltas
     * @throws RuntimeException si alguna entidad referenciada no existe en la BD
     */
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

    /**
     * {@inheritDoc}
     * <p>Resuelve las relaciones antes de persistir.</p>
     */
    @Override
    public Vuelo createVuelo(Vuelo vuelo) {
        return vueloRepository.save(resolveRelations(vuelo));
    }

    /**
     * {@inheritDoc}
     * <p>Carga el vuelo existente y actualiza solo sus campos.</p>
     */
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

    /**
     * {@inheritDoc}
     */
    @Override
    public void deleteVuelo(Long id) {
        vueloRepository.deleteById(id);
    }
}
