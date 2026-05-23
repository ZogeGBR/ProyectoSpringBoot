package com.example.vuelos.repository;

import com.example.vuelos.model.Aerolinea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AerolineaRepository extends JpaRepository<Aerolinea, Long> {
    // Metodos personalizados (si son necesarios)
}
