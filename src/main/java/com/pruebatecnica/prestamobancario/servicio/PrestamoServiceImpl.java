package com.pruebatecnica.prestamobancario.servicio;

import com.pruebatecnica.prestamobancario.dao.EstadoPrestamoDao;
import com.pruebatecnica.prestamobancario.dao.PagoPrestamoDao;
import com.pruebatecnica.prestamobancario.dao.PrestamoDao;
import com.pruebatecnica.prestamobancario.dominio.EstadoPrestamo;
import com.pruebatecnica.prestamobancario.dominio.Prestamo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class PrestamoServiceImpl implements PrestamoService {

    @Autowired
    PrestamoDao prestamoDao;

    @Autowired
    PagoPrestamoDao pagoPrestamoDao;

    @Autowired
    EstadoPrestamoDao estadoPrestamoDao;

    @Override
    public List<Prestamo> obtenerPrestamosAprobadosPorCui(String cui) {
        return prestamoDao.findPrestamosActivosPorCui(cui);
    }

    @Override
    public Prestamo buscarPorId(Integer idPrestamo) {
        return prestamoDao.findById(idPrestamo).orElseThrow();
    }

    @Override
    public BigDecimal calcularSaldoPendiente(Integer idPrestamo) {
        Prestamo prestamo = prestamoDao.findById(idPrestamo).orElseThrow();
        BigDecimal montoPagado = pagoPrestamoDao.totalPagadoPorPrestamo(idPrestamo);

        if (montoPagado == null) {
            montoPagado = BigDecimal.ZERO;
        }

        return prestamo.getSolicitudPrestamo().getMontosolicitado().subtract(montoPagado);
    }

    @Override
    public void verificarYActualizarEstadoSiCancelado(Integer idPrestamo) {
        BigDecimal saldo = calcularSaldoPendiente(idPrestamo);
        if (saldo.compareTo(BigDecimal.ZERO) <= 0) {
            Prestamo prestamo = prestamoDao.findById(idPrestamo).orElseThrow();
            EstadoPrestamo cancelado = estadoPrestamoDao.findByNombreestadoPrestamo("Cancelado");
            prestamo.setEstadoPrestamo(cancelado);
            prestamoDao.save(prestamo);
        }
    }


}
