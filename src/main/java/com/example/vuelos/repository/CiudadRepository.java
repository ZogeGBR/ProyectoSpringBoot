package com.example.vuelos.repository;

import com.example.vuelos.model.Ciudad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CiudadRepository extends JpaRepository<Ciudad, Long> {
    // Metodos personalizados (si son necesarios)
}
