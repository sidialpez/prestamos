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
    private Long idsolicitudprestamo;

    private BigDecimal montosolicitado;
    private Integer plazo;

    @Temporal(TemporalType.DATE)
    private Date fechasolicitud;

    @ManyToOne
    @JoinColumn(name="estadosolicitud_idestadosolicitud")
    private EstadoSolicitud estadoSolicitud;

    @ManyToOne
    @JoinColumn(name="cliente_idcliente")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name="usuario_idusuario")
    private Usuario idusuario;

}
