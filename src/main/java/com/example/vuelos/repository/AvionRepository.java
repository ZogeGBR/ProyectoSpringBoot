package com.example.vuelos.repository;

import com.example.vuelos.model.Avion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositorio JPA para la entidad {@link Avion}.
 *
 * <p>Extiende {@link JpaRepository}, que provee automáticamente los métodos
 * CRUD básicos: {@code findAll()}, {@code findById()}, {@code save()},
 * {@code deleteById()}, entre otros, sin necesidad de implementarlos.</p>
 *
 * <p>Para agregar consultas personalizadas, se pueden declarar métodos
 * usando la convención de nombres de Spring Data JPA, por ejemplo:
 * {@code findByNombreAvion(String nombre)}.</p>
 *
 * @author Zoe García Badiola
 * @version 1.0
 * @see Avion
 */
@Repository
public interface AvionRepository extends JpaRepository<Avion, Long> {
    // Métodos personalizados (si son necesarios)
}
