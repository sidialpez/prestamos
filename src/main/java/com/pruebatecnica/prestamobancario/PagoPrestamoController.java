package com.pruebatecnica.prestamobancario;

import com.pruebatecnica.prestamobancario.dominio.PagoPrestamo;
import com.pruebatecnica.prestamobancario.dominio.Prestamo;
import com.pruebatecnica.prestamobancario.dominio.Usuario;
import com.pruebatecnica.prestamobancario.servicio.PagoPrestamoService;
import com.pruebatecnica.prestamobancario.servicio.PrestamoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@Slf4j
@Controller
@RequestMapping("/pagos")
public class PagoPrestamoController {

    @Autowired
    private PrestamoService prestamoService;

    @Autowired
    private PagoPrestamoService pagoPrestamoService;

    @GetMapping("/registrar/{id}")
    public String mostrarFormularioPago(@PathVariable("id") Integer idPrestamo, Model model) {
        Prestamo prestamo = prestamoService.buscarPorId(idPrestamo);
        PagoPrestamo pago = new PagoPrestamo();
        pago.setPrestamo(prestamo);
        model.addAttribute("pago", pago);
        return "formularioPago";
    }

    @PostMapping("/guardar")
    public String guardarPago(@ModelAttribute("pago") PagoPrestamo pago) {
        pago.setFechapagoprestamo(new Date());

        Usuario usuario = new Usuario();
        usuario.setIdusuario(1L); // Reemplaza por usuario actual si usas login
        pago.setUsuario(usuario);

        pagoPrestamoService.guardar(pago);

        prestamoService.verificarYActualizarEstadoSiCancelado(pago.getPrestamo().getIdprestamo());

        Prestamo prestamo = new Prestamo();
        prestamo = prestamoService.buscarPorId(pago.getPrestamo().getIdprestamo());

        return "redirect:/prestamos/aprobados?cui=" + prestamo.getSolicitudPrestamo().getCliente().getCui();
    }
}
