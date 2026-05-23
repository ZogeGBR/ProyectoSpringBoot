package com.example.vuelos.service;

import com.example.vuelos.model.Consulta;
import java.util.List;

public interface ConsultaService {
    List<Consulta> getAllConsultas();
    Consulta getConsultaById(Long id);
    Consulta createConsulta(Consulta consulta);
    Consulta updateConsulta(Long id, Consulta consulta);
    void deleteConsulta(Long id);
}
