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
    private Long idprestamo;

    private BigDecimal montoaprobado;

    @Temporal(TemporalType.DATE)
    private Date fechaaprobacion;

    private BigDecimal tasainteres;
    private BigDecimal saldopendiente;

    @ManyToOne
    @JoinColumn(name = "idsolicitudprestamo")
    private SolicitudPrestamo solicitudPrestamo;

    @ManyToOne
    @JoinColumn(name = "idestadoprestamo")
    private EstadoPrestamo estadoPrestamo;
}
