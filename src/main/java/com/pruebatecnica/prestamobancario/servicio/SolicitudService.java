package com.pruebatecnica.prestamobancario.servicio;

import com.pruebatecnica.prestamobancario.dominio.SolicitudPrestamo;

import java.util.List;

public interface SolicitudService {

    public void guardar(SolicitudPrestamo solicitudPrestamo);

    List<SolicitudPrestamo> obtenerSolicitudesPendientesPorCui(String cui);

    void actualizarEstadoSolicitud(Integer idSolicitud, String nuevoEstado);


}
