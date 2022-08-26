package com.bancobisa.flujocaja.apiflujocajabisa.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "dominios", schema = "transversal")
public class DominioEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    @Column(name = "dominio_id")
    private Long dominioId;

    @Getter @Setter
    private String dominio;

    @Getter @Setter
    private String descripcion;

    @Getter @Setter @Column(name = "fecha_registro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRegistro;

    @Getter @Setter @Column(name = "estado_id")
    private Integer estadoId;


}
