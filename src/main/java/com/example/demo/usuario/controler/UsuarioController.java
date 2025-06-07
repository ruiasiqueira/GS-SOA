package com.example.demo.usuario.controler;


import com.example.demo.usuario.model.Usuario;
import org.springframework.stereotype.Service;
import com.example.demo.usuario.dto.UsuarioDTO;
import com.example.demo.usuario.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.demo.usuario.dto.LoginRequestDTO;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    @PostMapping
    public UsuarioDTO criar(@RequestBody Usuario usuario) {
        return service.salvar(usuario);
    }

    @GetMapping
    public List<UsuarioDTO> listar() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public UsuarioDTO buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

     @PostMapping("/login")
    public String login(@RequestBody LoginRequestDTO loginDTO) {
        boolean sucesso = service.login(loginDTO);

        if (sucesso) {
            return "Login bem-sucedido!";
        } else {
            return "Email ou senha incorretos.";
        }
    }
}
