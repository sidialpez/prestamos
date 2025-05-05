package com.pruebatecnica.prestamobancario.servicio;

import com.pruebatecnica.prestamobancario.dao.EstadoSolicitudDao;
import com.pruebatecnica.prestamobancario.dominio.EstadoSolicitud;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EstadoSolicitudImpl implements EstadoSolicitudService {

    @Autowired
    private EstadoSolicitudDao estadoSolicitudDao;

    @Override
    @Transactional(readOnly = true)
    public List<EstadoSolicitud> listarEstadoSolicitud() {
        return estadoSolicitudDao.findByEliminado("0");
    }

}
