package com.example.petshop.DanGetall;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.petshop.DanCliente.DanCliente;
import com.example.petshop.DanRepository.DanClienteRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/clientes")
public class DanClienteController {

    @Autowired
    private DanClienteRepository danClienteRepository;

    // Método para obtener todos los clientes
    @GetMapping("/danGetall")
    public List<DanCliente> getAllClientes() {
        return danClienteRepository.findAll();
    }

    // Método para insertar un cliente
    @PostMapping("/danSave")
    public DanCliente saveCliente(@RequestBody DanCliente cliente) {
        return danClienteRepository.save(cliente);
    }

    // Método para borrar un cliente por nombre
    @DeleteMapping("/danDelete/{nombre}")
    public ResponseEntity<Void> deleteClienteByNombre(@PathVariable String nombre) {
        Optional<DanCliente> cliente = danClienteRepository.findByNombre(nombre);
        if (cliente.isPresent()) {
            danClienteRepository.deleteByNombre(nombre);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}