package com.example.vuelos.service;

import com.example.vuelos.model.Reserva;
import java.util.List;

public interface ReservaService {
    List<Reserva> getAllReservas();
    Reserva getReservaById(Long id);
    Reserva createReserva(Reserva reserva);
    Reserva updateReserva(Long id, Reserva reserva);
    void deleteReserva(Long id);
}
