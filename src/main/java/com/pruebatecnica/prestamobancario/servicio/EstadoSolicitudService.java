package com.pruebatecnica.prestamobancario.servicio;

import com.pruebatecnica.prestamobancario.dao.EstadoSolicitudDao;
import com.pruebatecnica.prestamobancario.dominio.EstadoSolicitud;

import java.util.List;

public interface EstadoSolicitudService {

    public List<EstadoSolicitud> listarEstadoSolicitud();

}
