package com.bancobisa.flujocaja.apiflujocajabisa.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

public class HistoricoTransaccionDto {

    @Getter @Setter
    private String nombreCliente;

    @Getter @Setter
    private String apPaterno;

    @Getter @Setter
    private String apMaterno;

    @Getter @Setter
    private String nroCuenta;

    @Getter @Setter
    private Double deposito;

    @Getter @Setter
    private Double retiro;
    @Getter @Setter
    private Double monto;

    @Getter @Setter
    private String tipoTransaccion;

    public HistoricoTransaccionDto(String nombreCliente, String apPaterno, String apMaterno, String nroCuenta, Double deposito,Double retiro,Double  monto, String tipoTransaccion) {
        this.nombreCliente = nombreCliente;
        this.apPaterno = apPaterno;
        this.apMaterno = apMaterno;
        this.nroCuenta = nroCuenta;
        this.deposito = deposito;
        this.retiro = retiro;
        this.monto = monto;
        this.tipoTransaccion = tipoTransaccion;
    }
}
