package com.example.petshop.DanSave;


import com.example.petshop.DanClientecontroller.Danclienterepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/clientes")
public class DanClienteController {

    @Autowired
    private Danclienterepository danClienteRepository;

    // Método para obtener todos los clientes
    @GetMapping("/danGetall")
    public List<com.example.petshop.DanCliente.DanCliente> getAllClientes() {
        return danClienteRepository.findAll();
    }

    // Método para insertar un cliente
    @PostMapping("/danSave")
    public com.example.petshop.DanClientecontroller.DanClienteController saveCliente(@RequestBody com.example.petshop.DanClientecontroller.DanClienteController cliente) {
        return danClienteRepository.save(cliente);
    }

    // Método para borrar un cliente por nombre
    @DeleteMapping("/danDelete/{nombre}")
    public ResponseEntity<Void> deleteClienteByNombre(@PathVariable String nombre) {
        Optional<com.example.petshop.DanCliente.DanCliente> cliente = danClienteRepository.findByNombre(nombre);
        if (cliente.isPresent()) {
            danClienteRepository.deleteByNombre(nombre);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
