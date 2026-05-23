package com.example.vuelos.repository;

import com.example.vuelos.model.Pago;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PagoRepository extends JpaRepository<Pago, Long> {
    // Metodos personalizados (si son necesarios)
}
