package com.pruebatecnica.prestamobancario.servicio;

import com.pruebatecnica.prestamobancario.dao.PrestamoDao;
import com.pruebatecnica.prestamobancario.dominio.Prestamo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrestamoServiceImpl implements PrestamoService {

    @Autowired
    PrestamoDao prestamoDao;

    @Override
    public List<Prestamo> obtenerPrestamosAprobadosPorCui(String cui) {
        return prestamoDao.findPrestamosActivosPorCui(cui);
    }


}
