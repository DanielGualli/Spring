package com.example.petshop.DanRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.petshop.DanCliente.DanCliente;
import com.example.petshop.DanClientecontroller.DanClienteController;

import java.util.Optional;

public interface DanClienteRepository extends JpaRepository<DanCliente, Long> {
    Optional<DanCliente> findByNombre(String nombre);
    void deleteByNombre(String nombre);
    DanClienteController save(DanClienteController cliente);
}