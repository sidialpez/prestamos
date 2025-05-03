package com.pruebatecnica.prestamobancario.dominio;

import lombok.Data;

import java.util.Date;

@Data
public class clsCliente {
    private String nombre;
    private String apellido;
    private String cui;
    private Date fechaNacimiento;
    private String direccion;
    private String correo;
    private String telefono;
    private String eliminado;
}
