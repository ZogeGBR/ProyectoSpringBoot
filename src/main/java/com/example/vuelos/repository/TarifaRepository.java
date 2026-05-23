package com.example.vuelos.repository;

import com.example.vuelos.model.Tarifa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TarifaRepository extends JpaRepository<Tarifa, Long> {
    // Metodos personalizados (si son necesarios)
}
