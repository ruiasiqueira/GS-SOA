package com.example.demo.usuario.service;

import com.example.demo.usuario.model.Usuario;
import com.example.demo.usuario.dto.UsuarioDTO;
import com.example.demo.usuario.dto.LoginRequestDTO;
import com.example.demo.usuario.repository.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    public UsuarioDTO salvar(Usuario usuario) {
        Usuario salvo = repository.save(usuario);
        return new UsuarioDTO(salvo.getNome(), salvo.getEmail(), salvo.getTipoSanguineo(), salvo.getAlergia());
    }

    public List<UsuarioDTO> listarTodos() {
        return repository.findAll().stream()
                .map(u -> new UsuarioDTO(u.getNome(), u.getEmail(), u.getTipoSanguineo(), u.getAlergia()))
                .collect(Collectors.toList());
    }

    public UsuarioDTO buscarPorId(Long id) {
        Usuario usuario = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
        return new UsuarioDTO(usuario.getNome(), usuario.getEmail(), usuario.getTipoSanguineo(), usuario.getAlergia());
    }

    public boolean login(LoginRequestDTO loginDTO) {
        Optional<Usuario> usuarioOpt = repository.findAll().stream()
                .filter(u -> u.getEmail().equals(loginDTO.getEmail()))
                .findFirst();

        return usuarioOpt.map(usuario -> usuario.getSenha().equals(loginDTO.getSenha())).orElse(false);
    }
}