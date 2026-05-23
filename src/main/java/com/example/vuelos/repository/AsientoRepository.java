package com.example.vuelos.repository;

import com.example.vuelos.model.Asiento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AsientoRepository extends JpaRepository<Asiento, Long> {
    // Metodos personalizados (si son necesarios)
}
