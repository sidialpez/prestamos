package com.pruebatecnica.prestamobancario;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class PagosController {
    @GetMapping("/pagos")
    public String mostrarPagos() {
        return "pagos";
    }

}
