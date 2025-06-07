package com.example.demo.emergencia.controler;


import com.example.demo.emergencia.dto.EmergenciaDTO;
import com.example.demo.emergencia.model.Emergencia;
import com.example.demo.emergencia.service.EmergenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/emergencias")
public class emegrenciacontroler {

    @Autowired
    private EmergenciaService emergenciaService;

    @PostMapping
    public EmergenciaDTO criar(@RequestBody EmergenciaDTO dto) {
        return emergenciaService.criar(dto);
    }

    @GetMapping
    public List<Emergencia> listar() {
        return emergenciaService.listar();
    }

    @GetMapping("/{id}")
    public Optional<Emergencia> buscarPorId(@PathVariable Long id) {
        return emergenciaService.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public Optional<Emergencia> atualizar(@PathVariable Long id, @RequestBody EmergenciaDTO dto) {
        return emergenciaService.atualizar(id, dto);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        emergenciaService.deletar(id);
    }
}
