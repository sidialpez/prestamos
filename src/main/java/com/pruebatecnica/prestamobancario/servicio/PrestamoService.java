package com.pruebatecnica.prestamobancario.servicio;

import com.pruebatecnica.prestamobancario.dominio.Prestamo;

import java.math.BigDecimal;
import java.util.List;

public interface PrestamoService {
    List<Prestamo> obtenerPrestamosAprobadosPorCui(String cui);
    Prestamo buscarPorId(Integer idPrestamo);
    BigDecimal calcularSaldoPendiente(Integer idPrestamo);

}
