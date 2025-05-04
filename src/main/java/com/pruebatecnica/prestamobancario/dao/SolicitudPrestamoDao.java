package com.pruebatecnica.prestamobancario.dao;

import com.pruebatecnica.prestamobancario.dominio.SolicitudPrestamo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SolicitudPrestamoDao extends CrudRepository<SolicitudPrestamo,Integer> {

    @Query("SELECT s FROM SolicitudPrestamo s " +
            "JOIN s.cliente c " +
            "JOIN s.estadoSolicitud e " +
            "WHERE c.cui = :cui")
    List<SolicitudPrestamo> encontrarSolicitudesEnProcesoPorCui(@Param("cui") String cui);


}
