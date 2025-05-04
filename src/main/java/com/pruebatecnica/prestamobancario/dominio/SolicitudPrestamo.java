package com.pruebatecnica.prestamobancario.dominio;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
@Entity
@Table(name="solicitudprestamo")
public class SolicitudPrestamo implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idsolicitudprestamo;

    private BigDecimal montosolicitado;
    private Integer plazo;
    private Date fechasolicitud;
    private Integer estadosolicitud;
    private Integer idcliente;
    private Integer idusuario;

}
