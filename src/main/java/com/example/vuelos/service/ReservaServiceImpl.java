package com.example.vuelos.service;

import com.example.vuelos.model.Pago;
import com.example.vuelos.model.Reserva;
import com.example.vuelos.model.Usuario;
import com.example.vuelos.model.Vuelo;
import com.example.vuelos.repository.PagoRepository;
import com.example.vuelos.repository.ReservaRepository;
import com.example.vuelos.repository.UsuarioRepository;
import com.example.vuelos.repository.VueloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * Implementación del servicio de gestión de reservas.
 *
 * <p>Resuelve las entidades relacionadas ({@link Vuelo}, {@link Usuario}, {@link Pago})
 * desde la base de datos antes de persistir, evitando el error de Hibernate
 * {@code "detached entity passed to persist"}.</p>
 *
 * @author Zoe García Badiola
 * @version 1.0
 * @see ReservaService
 */
@Service
public class ReservaServiceImpl implements ReservaService {

    private final ReservaRepository reservaRepository;
    private final VueloRepository vueloRepository;
    private final UsuarioRepository usuarioRepository;
    private final PagoRepository pagoRepository;

    /**
     * Constructor con inyección de dependencias.
     *
     * @param reservaRepository  repositorio de reservas
     * @param vueloRepository    repositorio para resolver vuelos
     * @param usuarioRepository  repositorio para resolver usuarios
     * @param pagoRepository     repositorio para resolver pagos
     */
    @Autowired
    public ReservaServiceImpl(ReservaRepository reservaRepository,
                               VueloRepository vueloRepository,
                               UsuarioRepository usuarioRepository,
                               PagoRepository pagoRepository) {
        this.reservaRepository = reservaRepository;
        this.vueloRepository = vueloRepository;
        this.usuarioRepository = usuarioRepository;
        this.pagoRepository = pagoRepository;
    }

    /** {@inheritDoc} */
    @Override
    public List<Reserva> getAllReservas() {
        return reservaRepository.findAll();
    }

    /** {@inheritDoc} */
    @Override
    public Reserva getReservaById(Long id) {
        return reservaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Reserva no encontrada"));
    }

    /**
     * {@inheritDoc}
     *
     * <p>Carga cada entidad relacionada (vuelo, usuario, pago) desde la BD
     * para que Hibernate las reconozca como entidades "managed" y no intente
     * hacer un INSERT duplicado.</p>
     */
    @Override
    public Reserva createReserva(Reserva reserva) {
        if (reserva.getVuelo() != null && reserva.getVuelo().getId() != null) {
            Vuelo vuelo = vueloRepository.findById(reserva.getVuelo().getId())
                    .orElseThrow(() -> new RuntimeException("Vuelo no encontrado"));
            reserva.setVuelo(vuelo);
        }
        if (reserva.getUsuario() != null && reserva.getUsuario().getId() != null) {
            Usuario usuario = usuarioRepository.findById(reserva.getUsuario().getId())
                    .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
            reserva.setUsuario(usuario);
        }
        if (reserva.getPago() != null && reserva.getPago().getId() != null) {
            Pago pago = pagoRepository.findById(reserva.getPago().getId())
                    .orElseThrow(() -> new RuntimeException("Pago no encontrado"));
            reserva.setPago(pago);
        }
        return reservaRepository.save(reserva);
    }

    /** {@inheritDoc} */
    @Override
    public Reserva updateReserva(Long id, Reserva reserva) {
        Reserva existing = getReservaById(id);
        existing.setNumeroReserva(reserva.getNumeroReserva());
        if (reserva.getVuelo() != null && reserva.getVuelo().getId() != null) {
            existing.setVuelo(vueloRepository.findById(reserva.getVuelo().getId())
                    .orElseThrow(() -> new RuntimeException("Vuelo no encontrado")));
        }
        if (reserva.getUsuario() != null && reserva.getUsuario().getId() != null) {
            existing.setUsuario(usuarioRepository.findById(reserva.getUsuario().getId())
                    .orElseThrow(() -> new RuntimeException("Usuario no encontrado")));
        }
        if (reserva.getPago() != null && reserva.getPago().getId() != null) {
            existing.setPago(pagoRepository.findById(reserva.getPago().getId())
                    .orElseThrow(() -> new RuntimeException("Pago no encontrado")));
        }
        return reservaRepository.save(existing);
    }

    /** {@inheritDoc} */
    @Override
    public void deleteReserva(Long id) {
        reservaRepository.deleteById(id);
    }
}
