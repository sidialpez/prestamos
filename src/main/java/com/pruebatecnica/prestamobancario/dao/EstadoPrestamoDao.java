package com.pruebatecnica.prestamobancario.dao;

import com.pruebatecnica.prestamobancario.dominio.EstadoPrestamo;
import org.springframework.data.repository.CrudRepository;

public interface EstadoPrestamoDao extends CrudRepository<EstadoPrestamo, Integer> {

    EstadoPrestamo findByNombreestadoPrestamo(String nombreestadoPrestamo);
}
