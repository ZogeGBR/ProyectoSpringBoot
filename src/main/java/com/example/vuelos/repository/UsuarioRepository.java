package com.example.vuelos.repository;

import com.example.vuelos.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    // Metodos personalizados (si son necesarios)
}
