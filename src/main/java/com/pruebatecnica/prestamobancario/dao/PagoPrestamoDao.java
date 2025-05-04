package com.pruebatecnica.prestamobancario.dao;

import com.pruebatecnica.prestamobancario.dominio.PagoPrestamo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public interface PagoPrestamoDao extends CrudRepository<PagoPrestamo, Integer> {
    @Query("SELECT SUM(p.montopagado) FROM PagoPrestamo p WHERE p.prestamo.idprestamo = :idPrestamo")
    BigDecimal totalPagadoPorPrestamo(@Param("idPrestamo") Integer idPrestamo);

}
