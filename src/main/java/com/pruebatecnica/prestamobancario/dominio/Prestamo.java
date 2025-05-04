package com.pruebatecnica.prestamobancario.dominio;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
@Entity
@Table (name="prestamo")
public class Prestamo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idprestamo;

    @ManyToOne
    @JoinColumn(name = "idsolicitudprestamo", nullable = false)
    private SolicitudPrestamo solicitudPrestamo;

    @Temporal(TemporalType.DATE)
    @Column(name = "fechaaprobacion", nullable = false)
    private Date fechaaprobacion;

    @ManyToOne
    @JoinColumn(name = "estadoprestamo_idestadoprestamo", nullable = false)
    private EstadoPrestamo estadoPrestamo;

    @ManyToOne
    @JoinColumn(name = "idusuario")
    private Usuario usuario;
}