package com.bancobisa.flujocaja.apiflujocajabisa.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;

public class CuentaDto {


    public CuentaDto(Long cuentaId,String numeroCuenta, Long clienteId, String nombreCuenta, String descripcion, Long moneda, Double saldo) {
        this.cuentaId = cuentaId;
        this.numeroCuenta = numeroCuenta;
        this.clienteId = clienteId;
        this.nombreCuenta = nombreCuenta;
        this.descripcion = descripcion;
        this.moneda = moneda;
        this.saldo = saldo;
    }

    @Getter @Setter
    private  Long cuentaId;
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
