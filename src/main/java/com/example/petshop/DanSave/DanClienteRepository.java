package com.example.petshop.DanSave;


import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DanClienteRepository extends JpaRepository<DanCliente, Long> {
    Optional<DanCliente> findByNombre(String nombre);
    void deleteByNombre(String nombre);
}