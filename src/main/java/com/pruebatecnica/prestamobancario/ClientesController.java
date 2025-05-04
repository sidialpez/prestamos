package com.pruebatecnica.prestamobancario;

import com.pruebatecnica.prestamobancario.dominio.Cliente;
import com.pruebatecnica.prestamobancario.servicio.ClienteService;
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

    //Consultar todos los clientes
    @GetMapping("/clientes")
    public String mostrarClientes(Model model) {
        var clientes = clienteService.listarClientes();
        log.info("Mostrando Clientes");
        log.info("Clientes: {}", clientes);
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

    @GetMapping("/editarCliente/{idcliente}")
    public String editar(Cliente cliente, Model model) {
        cliente = clienteService.buscar(cliente);
        model.addAttribute("cliente", cliente);
        return "modificarCliente";
    }


    @GetMapping("/eliminarCliente/{idcliente}")
    public String eliminar(Cliente cliente) {
        cliente = clienteService.buscar(cliente);
        cliente.setEliminado("1");
        clienteService.eliminar(cliente);
        return "redirect:/clientes";
    }


}
