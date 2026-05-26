package com.example.vuelos.repository;

import com.example.vuelos.model.Pago;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositorio JPA para la entidad {@link Pago}.
 *
 * <p>Extiende {@link JpaRepository}, que provee automáticamente los métodos
 * CRUD básicos: {@code findAll()}, {@code findById()}, {@code save()},
 * {@code deleteById()}, entre otros, sin necesidad de implementarlos.</p>
 *
 * <p>Para agregar consultas personalizadas, se pueden declarar métodos
 * usando la convención de nombres de Spring Data JPA, por ejemplo:
 * {@code findByNombrePago(String nombre)}.</p>
 *
 * @author Zoe García Badiola
 * @version 1.0
 * @see Pago
 */
@Repository
public interface PagoRepository extends JpaRepository<Pago, Long> {
    // Métodos personalizados (si son necesarios)
}
