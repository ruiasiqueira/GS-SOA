package com.example.demo.emergencia.repository;


import com.example.demo.emergencia.model.Emergencia;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmergenciaRepository extends JpaRepository<Emergencia, Long> {
}
