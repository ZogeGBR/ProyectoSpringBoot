package com.example.vuelos.repository;

import com.example.vuelos.model.Fecha;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FechaRepository extends JpaRepository<Fecha, Long> {
    // Metodos personalizados (si son necesarios)
}
