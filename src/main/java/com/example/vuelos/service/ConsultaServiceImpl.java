package com.example.vuelos.service;

import com.example.vuelos.model.Consulta;
import com.example.vuelos.model.Usuario;
import com.example.vuelos.repository.ConsultaRepository;
import com.example.vuelos.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ConsultaServiceImpl implements ConsultaService {

    private final ConsultaRepository consultaRepository;
    private final UsuarioRepository usuarioRepository;

    @Autowired
    public ConsultaServiceImpl(ConsultaRepository consultaRepository,
                                UsuarioRepository usuarioRepository) {
        this.consultaRepository = consultaRepository;
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public List<Consulta> getAllConsultas() {
        return consultaRepository.findAll();
    }

    @Override
    public Consulta getConsultaById(Long id) {
        return consultaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Consulta no encontrada"));
    }

    @Override
    public Consulta createConsulta(Consulta consulta) {
        if (consulta.getUsuario() != null && consulta.getUsuario().getId() != null) {
            Usuario usuario = usuarioRepository.findById(consulta.getUsuario().getId())
                    .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
            consulta.setUsuario(usuario);
        }
        return consultaRepository.save(consulta);
    }

    @Override
    public Consulta updateConsulta(Long id, Consulta consulta) {
        Consulta existing = getConsultaById(id);
        existing.setNumeroConsulta(consulta.getNumeroConsulta());
        if (consulta.getUsuario() != null && consulta.getUsuario().getId() != null) {
            Usuario usuario = usuarioRepository.findById(consulta.getUsuario().getId())
                    .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
            existing.setUsuario(usuario);
        }
        return consultaRepository.save(existing);
    }

    @Override
    public void deleteConsulta(Long id) {
        consultaRepository.deleteById(id);
    }
}
