package com.example.demo.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.modelos.Clientes;
public interface ClientesRepository extends CrudRepository<Clientes, String>{

}
