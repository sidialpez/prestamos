package com.pruebatecnica.prestamobancario.dao;

import com.pruebatecnica.prestamobancario.dominio.SolicitudPrestamo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SolicitudPrestamoDao extends CrudRepository<SolicitudPrestamo,Integer> {
}
