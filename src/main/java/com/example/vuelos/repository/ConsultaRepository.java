package com.example.vuelos.repository;

import com.example.vuelos.model.Consulta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsultaRepository extends JpaRepository<Consulta, Long> {
    // Metodos personalizados (si son necesarios)
}
