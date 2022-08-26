package com.bancobisa.flujocaja.apiflujocajabisa.dao;

import com.bancobisa.flujocaja.apiflujocajabisa.entity.CuentaEntity;
import com.bancobisa.flujocaja.apiflujocajabisa.entity.DatosClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IDatosClienteDao extends JpaRepository<DatosClienteEntity, Long> {

    @Query("SELECT c.saldo " +
            "FROM CuentaEntity c " +
            "WHERE c.numeroCuenta = :pNroCuenta AND c.estadoId = 1000")
    public Double buscarSaldoPorNroCuenta(@Param("pNroCuenta") String pNroCuenta);

}
