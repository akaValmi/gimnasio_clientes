package com.example.demo.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.modelos.Clientes;
import com.example.demo.repositories.ClientesRepository;
import com.example.demo.services.ClientesService;

@Service
public class ClientesServiceImpl implements ClientesService {

    @Autowired
    private ClientesRepository clienteRepository;

    @Override
    public Clientes guardarCliente(Clientes cliente) {
        return clienteRepository.save(cliente);
    }

    @Override
    public Optional<Clientes> buscarPorId(String dni) {
        Optional<Clientes> cliente = clienteRepository.findById(dni);
        return cliente;
    }
    @Override
    public void eliminarCliente(String dni) {
        Optional<Clientes> optionalCliente = clienteRepository.findById(dni);
        if (optionalCliente.isPresent()) {
            clienteRepository.deleteById(dni);
        } else {
        }
    }

    @Override
    public Clientes actualizarCliente(String dni, Clientes clienteActualizado) {
        Optional<Clientes> optionalCliente = clienteRepository.findById(dni);
        if (optionalCliente.isPresent()) {
            Clientes clienteExistente = optionalCliente.get();
            clienteExistente.setNombre(clienteActualizado.getNombre());
            clienteExistente.setApellido(clienteActualizado.getApellido());
            clienteExistente.setFechaNacimiento(clienteActualizado.getFechaNacimiento());
            clienteExistente.setGenero(clienteActualizado.getGenero());
            return clienteRepository.save(clienteExistente);
        } else {
            return null;
        }
    }

    @Override
    public List<Clientes> mostrarClientes() {
        return (List<Clientes>) clienteRepository.findAll();
    }

	

}
