package com.example.demo.controllers;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.modelos.Clientes;
import com.example.demo.services.impl.ClientesServiceImpl;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    @Autowired
    private ClientesServiceImpl clienteImplementacionService;

    @PostMapping("/crear")
    public Clientes crearCliente(@RequestBody Clientes cliente) throws ParseException {
        return clienteImplementacionService.guardarCliente(cliente);
    }

    @GetMapping("/buscar/{dni}")
    public Clientes buscarCliente(@PathVariable(name = "dni") String dni) {
    	return clienteImplementacionService.buscarPorId(dni)
                .orElse(null);
    }
    
    @PutMapping("/actualizar/{dni}")
    public Clientes actualizarCliente(@PathVariable(name = "dni") String dni, @RequestBody Clientes cliente) {
        return clienteImplementacionService.actualizarCliente(dni, cliente);
    }

    @DeleteMapping("/eliminar/{dni}")
    public void eliminarCliente(@PathVariable(name = "dni") String dni) {
        clienteImplementacionService.eliminarCliente(dni);
    }
    
    @GetMapping("/mostrar")
    public List<Clientes> mostrarClientes() {
        return clienteImplementacionService.mostrarClientes();
    }
}
