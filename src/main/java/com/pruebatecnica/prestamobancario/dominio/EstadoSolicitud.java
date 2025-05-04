package com.pruebatecnica.prestamobancario.dominio;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name = "estadosolicitud")
public class EstadoSolicitud implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idestadosolicitud;

    private String nombreestado;
    private String eliminado;
}
