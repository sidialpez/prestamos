package com.pruebatecnica.prestamobancario;

import com.pruebatecnica.prestamobancario.dominio.Cliente;
import com.pruebatecnica.prestamobancario.dominio.EstadoSolicitud;
import com.pruebatecnica.prestamobancario.dominio.SolicitudPrestamo;
import com.pruebatecnica.prestamobancario.dominio.Usuario;
import com.pruebatecnica.prestamobancario.servicio.SolicitudService;
import com.pruebatecnica.prestamobancario.servicio.SolicitudServiceImpl;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Date;

@Controller
@Slf4j

public class SolicitudesController {

    @Autowired
    private SolicitudService solicitudService;

    @GetMapping("/crearSolicitud")
    public String mostrarSolicitudes() {

        return "crearSolicitud";
    }

    //Guardar una solicitud nueva
    @PostMapping("/guardarSolicitud")
    public String guardar(@Valid SolicitudPrestamo solicitud, Errors errors, RedirectAttributes redirectAttrs) {
        if(errors.hasErrors()) {
            return "crearSolicitud";
        }
        solicitud.setFechasolicitud(new Date());
        Usuario usuario = new Usuario();
        usuario.setIdusuario(1L);
        EstadoSolicitud estadoSolicitud = new EstadoSolicitud();
        estadoSolicitud.setIdestadosolicitud(3L);
        solicitud.setIdusuario(usuario);
        solicitud.setEstadoSolicitud(estadoSolicitud);
        solicitudService.guardar(solicitud);
        redirectAttrs.addFlashAttribute("exito", true);
        return "redirect:crearSolicitud";
    }

}
