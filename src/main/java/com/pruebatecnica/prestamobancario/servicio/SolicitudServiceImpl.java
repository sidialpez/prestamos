package com.pruebatecnica.prestamobancario.servicio;

import com.pruebatecnica.prestamobancario.dao.ClienteDao;
import com.pruebatecnica.prestamobancario.dao.EstadoSolicitudDao;
import com.pruebatecnica.prestamobancario.dao.SolicitudPrestamoDao;
import com.pruebatecnica.prestamobancario.dominio.EstadoSolicitud;
import com.pruebatecnica.prestamobancario.dominio.SolicitudPrestamo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SolicitudServiceImpl implements SolicitudService {

    @Autowired
    private SolicitudPrestamoDao solicitudPrestamoDao;

    @Autowired
    private EstadoSolicitudDao estadoSolicitudDao;

    @Override
    public void guardar(SolicitudPrestamo solicitudPrestamo) {
        solicitudPrestamoDao.save(solicitudPrestamo);
    }

    @Override
    public List<SolicitudPrestamo> obtenerSolicitudesPendientesPorCui(String cui) {
        return solicitudPrestamoDao.encontrarSolicitudesEnProcesoPorCui(cui);
    }

    @Autowired
    private SolicitudPrestamoDao solicitudDao;

    @Override
    public void actualizarEstadoSolicitud(Integer idSolicitud, String nuevoEstado) {
        SolicitudPrestamo solicitud = solicitudDao.findById(idSolicitud).orElseThrow();
        EstadoSolicitud estado = estadoSolicitudDao.findByNombreestado(nuevoEstado);
        solicitud.setEstadoSolicitud(estado);
        solicitudDao.save(solicitud);
    }


}
