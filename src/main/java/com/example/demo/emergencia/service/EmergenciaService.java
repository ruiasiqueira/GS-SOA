package com.example.demo.emergencia.service;


import com.example.demo.emergencia.dto.EmergenciaDTO;
import com.example.demo.emergencia.model.Emergencia;
import com.example.demo.usuario.model.Usuario;
import com.example.demo.emergencia.repository.EmergenciaRepository;
import com.example.demo.usuario.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmergenciaService {

    @Autowired
    private EmergenciaRepository emergenciaRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public EmergenciaDTO criar(EmergenciaDTO dto) {
        Emergencia emergencia = new Emergencia();
        emergencia.setTipoEmergencia(dto.getTipoEmergencia());

        Optional<Usuario> usuarioOpt = usuarioRepository.findById(dto.getUsuarioId());
        usuarioOpt.ifPresent(emergencia::setUsuario);

        Emergencia salva = emergenciaRepository.save(emergencia);

        dto.setId(salva.getId());
        return dto;
    }

    public List<Emergencia> listar() {
        return emergenciaRepository.findAll();
    }

    public Optional<Emergencia> buscarPorId(Long id) {
        return emergenciaRepository.findById(id);
    }

    public Optional<Emergencia> atualizar(Long id, EmergenciaDTO dto) {
        return emergenciaRepository.findById(id).map(e -> {
            e.setTipoEmergencia(dto.getTipoEmergencia());
            return emergenciaRepository.save(e);
        });
    }

    public void deletar(Long id) {
        emergenciaRepository.deleteById(id);
    }
}
