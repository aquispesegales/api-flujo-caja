package com.bancobisa.flujocaja.apiflujocajabisa.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "log_errores", schema = "log")
public class LogErroresEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Getter @Setter @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "log_error_id")
    private Long logErrorId;

    @Getter @Setter @Column(name = "fecha_inicio")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaInicio;

    @Getter @Setter @Column(name = "fecha_fin")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaFin;

    private String hostname;

    @Getter @Setter @Column(name = "mensaje_usuario")
    private String mensajeUsuario;

    @Getter @Setter @Column(name = "mensaje_tecnico")
    private String mensajeTecnico;

    @Getter @Setter @Column(name = "fecha_registro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRegistro;

    @Getter
    @Setter
    @Column(name = "estado_id")
    private Integer estadoId;




}
