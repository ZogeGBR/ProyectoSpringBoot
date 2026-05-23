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

@Service
public class ReservaServiceImpl implements ReservaService {

    private final ReservaRepository reservaRepository;
    private final VueloRepository vueloRepository;
    private final UsuarioRepository usuarioRepository;
    private final PagoRepository pagoRepository;

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

    @Override
    public List<Reserva> getAllReservas() {
        return reservaRepository.findAll();
    }

    @Override
    public Reserva getReservaById(Long id) {
        return reservaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Reserva no encontrada"));
    }

    @Override
    public Reserva createReserva(Reserva reserva) {
        // Resolver entidades desde la BD para que Hibernate las reconozca como "managed"
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

    @Override
    public Reserva updateReserva(Long id, Reserva reserva) {
        Reserva existing = getReservaById(id);
        existing.setNumeroReserva(reserva.getNumeroReserva());

        if (reserva.getVuelo() != null && reserva.getVuelo().getId() != null) {
            Vuelo vuelo = vueloRepository.findById(reserva.getVuelo().getId())
                    .orElseThrow(() -> new RuntimeException("Vuelo no encontrado"));
            existing.setVuelo(vuelo);
        }
        if (reserva.getUsuario() != null && reserva.getUsuario().getId() != null) {
            Usuario usuario = usuarioRepository.findById(reserva.getUsuario().getId())
                    .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
            existing.setUsuario(usuario);
        }
        if (reserva.getPago() != null && reserva.getPago().getId() != null) {
            Pago pago = pagoRepository.findById(reserva.getPago().getId())
                    .orElseThrow(() -> new RuntimeException("Pago no encontrado"));
            existing.setPago(pago);
        }
        return reservaRepository.save(existing);
    }

    @Override
    public void deleteReserva(Long id) {
        reservaRepository.deleteById(id);
    }
}
