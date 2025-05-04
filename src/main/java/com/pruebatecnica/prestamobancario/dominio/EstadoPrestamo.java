package com.pruebatecnica.prestamobancario.dominio;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name = "estadoprestamo")
public class EstadoPrestamo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idestadoprestamo;

    @Column(name = "nombreestadoprestamo")
    private String nombreestadoPrestamo;


}

