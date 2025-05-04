package com.pruebatecnica.prestamobancario.dao;

import com.pruebatecnica.prestamobancario.dominio.Usuario;
import org.springframework.data.repository.CrudRepository;

public interface UsuarioDao extends CrudRepository<Usuario,Integer> {
}
