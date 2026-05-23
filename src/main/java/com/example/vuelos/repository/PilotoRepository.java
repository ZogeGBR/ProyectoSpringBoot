package com.example.vuelos.repository;

import com.example.vuelos.model.Piloto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PilotoRepository extends JpaRepository<Piloto, Long> {
    // Metodos personalizados (si son necesarios)
}
