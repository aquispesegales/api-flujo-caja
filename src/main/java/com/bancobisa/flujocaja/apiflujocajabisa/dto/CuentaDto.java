package com.bancobisa.flujocaja.apiflujocajabisa.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;

public class CuentaDto {

    @Getter @Setter
    private String numeroCuenta;

    @Getter @Setter
    private Long clienteId;

    @Getter @Setter
    private String nombreCuenta;

    @Getter @Setter
    private String descripcion;

    @Getter @Setter
    private Long moneda;

    @Getter @Setter
    private Double saldo;
}
