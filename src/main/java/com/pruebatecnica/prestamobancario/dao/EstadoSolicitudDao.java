package com.pruebatecnica.prestamobancario.dao;

import com.pruebatecnica.prestamobancario.dominio.Cliente;
import com.pruebatecnica.prestamobancario.dominio.EstadoSolicitud;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EstadoSolicitudDao extends CrudRepository<EstadoSolicitud, Long> {

    List<EstadoSolicitud> findByEliminado(String eliminado);

}
