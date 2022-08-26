package com.bancobisa.flujocaja.apiflujocajabisa.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;


@Entity
@Table(name = "transacciones", schema = "cuenta")
public class TransaccionEntity  implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "transaccion_id")
    private Long transaccionId;

    @Getter
    @Setter
    @Column(name = "cuenta_id")
    private Long cuentaId;

    @Getter @Setter
    private String detalle;

    @Getter @Setter
    private Double ingreso;

    @Getter @Setter
    private Double egreso;

    @Getter @Setter
    private Double saldo;

    @Getter @Setter  @Column(name = "tipo_transaccion_id")
    private Long tipoTransaccionId;

    @Getter @Setter    @Column(name = "fecha_registro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRegistro;

    @Getter @Setter  @Column(name = "estado_id")
    private Long estadoId;






}
