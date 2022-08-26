package com.bancobisa.flujocaja.apiflujocajabisa.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

public class TransaccionDto {

    @Getter @Setter
    private Long transaccionId;

    @Getter @Setter
    private Long cuentaId;

    @Getter @Setter
    private String detalle;

    @Getter @Setter
    private Double ingreso;

    @Getter @Setter
    private Double egreso;

    @Getter @Setter
    private Double saldo;

    @Getter @Setter
    private Long tipoTransaccionId;

    @Getter @Setter
    private Date fechaRegistro;

    @Getter @Setter
    private Long estadoId;
}
