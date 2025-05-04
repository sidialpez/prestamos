package com.pruebatecnica.prestamobancario.dominio;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name = "usuario")
public class Usuario implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idusuario;

    private String nombre;
    private String apellido;
    private String correo;
    private String contrasena;
    private String eliminado;
}
