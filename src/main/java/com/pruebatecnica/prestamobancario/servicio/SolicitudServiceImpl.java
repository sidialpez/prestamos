package com.pruebatecnica.prestamobancario.servicio;

import com.pruebatecnica.prestamobancario.dao.*;
import com.pruebatecnica.prestamobancario.dominio.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
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

    @Autowired
    private PrestamoDao prestamoDao;

    @Autowired
    private EstadoPrestamoDao estadoPrestamoDao;


    @Override
    public void actualizarEstadoSolicitud(Integer idSolicitud, String nuevoEstado) {
        SolicitudPrestamo solicitud = solicitudDao.findById(idSolicitud).orElseThrow();
        EstadoSolicitud estado = estadoSolicitudDao.findByNombreestado(nuevoEstado);
        solicitud.setEstadoSolicitud(estado);
        solicitudDao.save(solicitud);

        if (nuevoEstado.equalsIgnoreCase("Aprobado")) {
            Prestamo prestamo = new Prestamo();
            prestamo.setSolicitudPrestamo(solicitud);
            prestamo.setFechaaprobacion(new Date());

            EstadoPrestamo estadoPrestamo = estadoPrestamoDao.findByNombreestadoPrestamo("Activo");

            prestamo.setEstadoPrestamo(estadoPrestamo);

            Usuario usuario = new Usuario();
            usuario.setIdusuario(1L); // puedes obtener el usuario autenticado si usas Spring Security
            prestamo.setUsuario(usuario);

            prestamoDao.save(prestamo);
        }

    }


}
