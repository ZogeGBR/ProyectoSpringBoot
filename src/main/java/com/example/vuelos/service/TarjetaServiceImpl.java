package com.example.vuelos.service;

import com.example.vuelos.model.Tarjeta;
import com.example.vuelos.model.Usuario;
import com.example.vuelos.repository.TarjetaRepository;
import com.example.vuelos.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TarjetaServiceImpl implements TarjetaService {

    private final TarjetaRepository tarjetaRepository;
    private final UsuarioRepository usuarioRepository;

    @Autowired
    public TarjetaServiceImpl(TarjetaRepository tarjetaRepository,
                               UsuarioRepository usuarioRepository) {
        this.tarjetaRepository = tarjetaRepository;
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public List<Tarjeta> getAllTarjetas() {
        return tarjetaRepository.findAll();
    }

    @Override
    public Tarjeta getTarjetaById(Long id) {
        return tarjetaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tarjeta no encontrada"));
    }

    private Tarjeta resolveRelations(Tarjeta tarjeta) {
        if (tarjeta.getUsuario() != null && tarjeta.getUsuario().getId() != null) {
            Usuario usuario = usuarioRepository.findById(tarjeta.getUsuario().getId())
                    .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
            tarjeta.setUsuario(usuario);
        }
        return tarjeta;
    }

    @Override
    public Tarjeta createTarjeta(Tarjeta tarjeta) {
        return tarjetaRepository.save(resolveRelations(tarjeta));
    }

    @Override
    public Tarjeta updateTarjeta(Long id, Tarjeta tarjeta) {
        Tarjeta existing = getTarjetaById(id);
        existing.setNumeroTarjeta(tarjeta.getNumeroTarjeta());
        existing.setTipoTarjeta(tarjeta.getTipoTarjeta());
        existing.setNumeroPago(tarjeta.getNumeroPago());
        existing.setCantidadPago(tarjeta.getCantidadPago());
        resolveRelations(tarjeta);
        existing.setUsuario(tarjeta.getUsuario());
        return tarjetaRepository.save(existing);
    }

    @Override
    public void deleteTarjeta(Long id) {
        tarjetaRepository.deleteById(id);
    }
}
