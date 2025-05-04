package com.pruebatecnica.prestamobancario.dao;

import com.pruebatecnica.prestamobancario.dominio.Cliente;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface IClienteDao extends CrudRepository<Cliente,Long> {

    List<Cliente> findByEliminado(String eliminado);

}
