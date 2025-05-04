package com.pruebatecnica.prestamobancario.dominio;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
@Entity
@Table(name = "pagoprestamo")
public class PagoPrestamo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idpagoprestamo;

    @Temporal(TemporalType.DATE)
    @Column(name = "fechapagoprestamo", nullable = false)
    private Date fechapagoprestamo;

    @Column(name = "montopagado", nullable = false)
    private BigDecimal montopagado;

    @ManyToOne
    @JoinColumn(name = "idusuario", nullable = false)
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "prestamo_idprestamo", nullable = false)
    private Prestamo prestamo;
}