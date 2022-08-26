package com.bancobisa.flujocaja.apiflujocajabisa.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "datos_clientes", schema = "cliente")
public class DatosClienteEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    @Column(name = "cliente_id")
    private Long clienteId;

    @Getter @Setter @Column(name = "codigo_cliente")
    private String codigoCliente;


    private String nombres;

    @Getter @Setter @Column(name = "ap_paterno")
    private String apPaterno;

    @Getter @Setter @Column(name = "ap_materno")
    private String apMaterno;

    @Getter @Setter
    private String ci;

    @Getter @Setter
    private String direccion;

    @Getter @Setter @Column(name = "fecha_registro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRegistro;

    @Getter @Setter    @Column(name = "estado_id")
    private Integer estadoId;


}
