package com.example.petshop.DanGetall;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.petshop.DanCliente.DanCliente;

import java.util.Optional;

public interface DanClienteRepository extends JpaRepository<DanCliente, Long> {
    Optional<DanCliente> findByNombre(String nombre);
    void deleteByNombre(String nombre);
}
