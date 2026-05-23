package com.example.vuelos.service;

import com.example.vuelos.model.Usuario;
import com.example.vuelos.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public List<Usuario> getAllUsuarios() {
        return usuarioRepository.findAll();
    }

    @Override
    public Usuario getUsuarioById(Long id) {
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
    }

    @Override
    public Usuario createUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    public Usuario updateUsuario(Long id, Usuario usuario) {
        Usuario existing = getUsuarioById(id);
        existing.setNumeroUsuario(usuario.getNumeroUsuario());
        existing.setContraseniaUsuario(usuario.getContraseniaUsuario());
        existing.setCorreoElectronicoUsuario(usuario.getCorreoElectronicoUsuario());
        existing.setDniPersona(usuario.getDniPersona());
        existing.setNombrePersona(usuario.getNombrePersona());
        existing.setApellidoPersona(usuario.getApellidoPersona());
        return usuarioRepository.save(existing);
    }

    @Override
    public void deleteUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }
}
