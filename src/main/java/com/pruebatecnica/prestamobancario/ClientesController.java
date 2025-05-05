package com.pruebatecnica.prestamobancario;

import com.pruebatecnica.prestamobancario.dominio.Cliente;
import com.pruebatecnica.prestamobancario.dominio.SolicitudPrestamo;
import com.pruebatecnica.prestamobancario.servicio.ClienteService;
import com.pruebatecnica.prestamobancario.servicio.EstadoSolicitudService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import jakarta.validation.Valid;

@Controller
@Slf4j
public class ClientesController {


    @Autowired
    private ClienteService clienteService;
    @Autowired
    private EstadoSolicitudService estadoSolicitudService;

    //Consultar todos los clientes
    @GetMapping("/clientes")
    public String mostrarClientes(Model model) {
        var clientes = clienteService.listarClientes();
        model.addAttribute("clientes", clientes);
        return "clientes";
    }

    //Añadir un cliente nuevo
    @GetMapping("/agregarCliente")
    public String agregar(Cliente cliente) {
        return "modificarCliente";
    }

    //Guardar un cliente nuevo
    @PostMapping("/guardarCliente")
    public String guardar(@Valid Cliente cliente, Errors errors) {
        if(errors.hasErrors()) {
            return "modificarCliente";
        }
        cliente.setEliminado("0");
        clienteService.guardar(cliente);
        return "redirect:/clientes";
    }

    //Buscar la información para editar un cliente
    @GetMapping("/editarCliente/{idcliente}")
    public String editar(Cliente cliente, Model model) {
        cliente = clienteService.buscar(cliente);
        model.addAttribute("cliente", cliente);
        return "modificarCliente";
    }

    //Eliminar un cliente
    @GetMapping("/eliminarCliente/{idcliente}")
    public String eliminar(Cliente cliente) {
        cliente = clienteService.buscar(cliente);
        cliente.setEliminado("1");
        clienteService.eliminar(cliente);
        return "redirect:/clientes";
    }

    //Buscar la información para generar solicitud a un cliente
    @GetMapping("/buscarClienteCui")
    public String buscarClienteCui(String cui, Model model) {
        var cliente = clienteService.buscarClienteCui(cui);
        if (cliente == null) {
            model.addAttribute("noEncontrado", true);
        } else {
            SolicitudPrestamo solicitud = new SolicitudPrestamo();
            solicitud.setCliente(cliente);
            model.addAttribute("cliente", cliente);
            model.addAttribute("estados", estadoSolicitudService.listarEstadoSolicitud());
            model.addAttribute("solicitud", solicitud);
        }

        return "crearSolicitud";
    }

}
