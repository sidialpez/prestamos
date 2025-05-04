package com.pruebatecnica.prestamobancario;

import com.pruebatecnica.prestamobancario.dao.PrestamoDao;
import com.pruebatecnica.prestamobancario.dominio.Prestamo;
import com.pruebatecnica.prestamobancario.servicio.PrestamoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;
import java.util.List;

@Controller
@Slf4j
public class PrestamosController {

    @Autowired
    PrestamoService prestamoService;

    @GetMapping("/prestamos/aprobados")
    public String listarPrestamosActivosPorCui(@RequestParam(name = "cui", required = false) String cui, Model model) {
        if (cui != null && !cui.isEmpty()) {
            List<Prestamo> prestamos = prestamoService.obtenerPrestamosAprobadosPorCui(cui);
            model.addAttribute("prestamos", prestamos);
            model.addAttribute("cui", cui);
        }
        return "listadoPrestamos";
    }


    @GetMapping("/prestamos/saldo/{id}")
    public String verSaldo(@PathVariable("id") Integer idPrestamo, Model model) {
        Prestamo prestamo = prestamoService.buscarPorId(idPrestamo);
        BigDecimal saldo = prestamoService.calcularSaldoPendiente(idPrestamo);

        model.addAttribute("prestamo", prestamo);
        model.addAttribute("saldoPendiente", saldo);

        return "saldoPrestamo";
    }


}
