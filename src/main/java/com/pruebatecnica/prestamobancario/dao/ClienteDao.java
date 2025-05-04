package com.pruebatecnica.prestamobancario.dao;

import com.pruebatecnica.prestamobancario.dominio.Cliente;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface ClienteDao extends CrudRepository<Cliente,Long> {

    List<Cliente> findByEliminado(String eliminado);

    Cliente findByCui(String cui);

}
