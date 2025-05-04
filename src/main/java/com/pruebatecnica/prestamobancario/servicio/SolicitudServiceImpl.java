package com.pruebatecnica.prestamobancario.servicio;

import com.pruebatecnica.prestamobancario.dao.ClienteDao;
import com.pruebatecnica.prestamobancario.dao.SolicitudPrestamoDao;
import com.pruebatecnica.prestamobancario.dominio.SolicitudPrestamo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SolicitudServiceImpl implements SolicitudService {

    @Autowired
    private SolicitudPrestamoDao solicitudPrestamoDao;

    @Override
    public void guardar(SolicitudPrestamo solicitudPrestamo) {
        solicitudPrestamoDao.save(solicitudPrestamo);
    }
}
