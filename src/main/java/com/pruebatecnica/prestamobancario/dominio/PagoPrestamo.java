package com.pruebatecnica.prestamobancario.dominio;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
@Entity
@Table(name="pagosolicitud")
public class PagoPrestamo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idpagoprestamo;

    @Temporal(TemporalType.DATE)
    private Date fechapagoprestamo;

    private BigDecimal montopagado;

    @ManyToOne
    @JoinColumn(name = "idprestamo")
    private Prestamo prestamo;

    @ManyToOne
    @JoinColumn(name = "idusuario")
    private Usuario usuario;
}
