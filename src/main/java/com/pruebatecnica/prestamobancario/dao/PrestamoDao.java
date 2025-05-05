package com.pruebatecnica.prestamobancario.dao;

import com.pruebatecnica.prestamobancario.dominio.Prestamo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PrestamoDao extends CrudRepository<Prestamo, Integer> {

    @Query("SELECT p FROM Prestamo p " +
            "JOIN p.solicitudPrestamo s " +
            "JOIN s.cliente c " +
            "JOIN p.estadoPrestamo e " +
            "WHERE c.cui = :cui AND e.nombreestadoPrestamo = 'Activo'")
    List<Prestamo> findPrestamosActivosPorCui(@Param("cui") String cui);

}
