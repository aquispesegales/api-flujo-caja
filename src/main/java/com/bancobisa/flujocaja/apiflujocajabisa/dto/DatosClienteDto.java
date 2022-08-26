package com.bancobisa.flujocaja.apiflujocajabisa.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

public class DatosClienteDto {

    @Getter @Setter
    private Long clienteId;

    @Getter @Setter
    private String codigoCliente;

    @Getter @Setter
    private String nombres;

    @Getter @Setter
    private String apPaterno;

    @Getter @Setter
    private String apMaterno;

    @Getter @Setter
    private String ci;

    @Getter @Setter
    private String direccion;

    @Getter @Setter
    private Date fechaRegistro;

    @Getter @Setter
    private Long estadoId;
}
