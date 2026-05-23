package com.example.vuelos.repository;

import com.example.vuelos.model.Tarjeta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TarjetaRepository extends JpaRepository<Tarjeta, Long> {
    // Metodos personalizados (si son necesarios)
}
