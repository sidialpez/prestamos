package com.pruebatecnica.prestamobancario.dominio;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
@Entity
@Table (name="prestamo")
public class Prestamo implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idprestamo;
    private Integer idsolicitudprestamo;
    private BigDecimal montoaprobado;
    private Date fechaaprobacion;
    private Integer idestadoprestamo;
}
