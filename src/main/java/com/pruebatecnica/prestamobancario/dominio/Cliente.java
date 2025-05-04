package com.pruebatecnica.prestamobancario.dominio;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

@Data
@Entity
@Table(name = "cliente")
public class Cliente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idcliente;

    private String nombre;
    private String apellido;
    private String cui;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fechanacimiento;
    private String direccion;
    private String correo;
    private String telefono;
    private String eliminado;
}
