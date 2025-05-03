package com.pruebatecnica.prestamobancario;

import com.pruebatecnica.prestamobancario.dominio.clsCliente;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@Slf4j
public class ClientesController {

    @GetMapping("/")
    public String inicio(Model model) {
        var cliente = new clsCliente();
        cliente.setNombre("Sidia");
        cliente.setApellido("López");
        cliente.setTelefono("900-00-00");
        cliente.setCui("12345678901101");
        cliente.setCorreo("sidialpez@gmail.com");
        cliente.setDireccion("Guatemala");
        log.info("va por aqui");

        try{
            Date fecha = new SimpleDateFormat("dd/MM/yyyy").parse("15/03/1989");
            cliente.setFechaNacimiento(fecha);
        }catch (Exception ex){
            ex.printStackTrace();
        }

        //retornar los valores a la vista
        model.addAttribute("cliente", cliente);
        return "index";
    }

}
