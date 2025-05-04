package com.pruebatecnica.prestamobancario.servicio;

import com.pruebatecnica.prestamobancario.dao.PagoPrestamoDao;
import com.pruebatecnica.prestamobancario.dominio.PagoPrestamo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PagoPrestamoServiceImpl implements PagoPrestamoService {

    @Autowired
    private PagoPrestamoDao pagoPrestamoDao;

    @Override
    public void guardar(PagoPrestamo pago) {
        pagoPrestamoDao.save(pago);
    }
}
