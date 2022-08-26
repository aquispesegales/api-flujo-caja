package com.bancobisa.flujocaja.apiflujocajabisa.entity;

import com.fasterxml.jackson.databind.DatabindException;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "cuentas", schema = "cuenta")
public class CuentaEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter @Column(name = "cuenta_id")
    private  Long cuentaId;

    @Getter @Setter @Column(name = "numero_cuenta")
    private String numeroCuenta;

    @Getter @Setter @Column(name = "cliente_id")
    private Long clienteId;

    @Getter @Setter @Column(name = "nombre_cuenta")
    private String nombreCuenta;

    @Getter @Setter
    private String descripcion;

    @Getter @Setter
    private Long moneda;

    @Getter @Setter
    private Double saldo;

    @Getter @Setter @Column(name = "fecha_registro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRegistro;

    @Getter @Setter @Column(name = "estado_id")
    private Long estadoId;


}
