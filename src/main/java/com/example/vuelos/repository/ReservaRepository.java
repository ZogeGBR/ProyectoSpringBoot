package com.example.vuelos.repository;

import com.example.vuelos.model.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Long> {
    // Metodos personalizados (si son necesarios)
}
