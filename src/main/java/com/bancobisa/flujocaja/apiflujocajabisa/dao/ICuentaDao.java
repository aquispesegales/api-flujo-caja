package com.bancobisa.flujocaja.apiflujocajabisa.dao;

import com.bancobisa.flujocaja.apiflujocajabisa.dto.CuentaDto;
import com.bancobisa.flujocaja.apiflujocajabisa.dto.DatosClienteDto;
import com.bancobisa.flujocaja.apiflujocajabisa.entity.CuentaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ICuentaDao extends JpaRepository<CuentaEntity, Long> {
    @Query("SELECT c.saldo " +
            "FROM CuentaEntity c " +
            "WHERE c.numeroCuenta = :pNroCuenta AND c.estadoId = 1000")
    public Double buscarSaldoPorNroCuenta(@Param("pNroCuenta") String pNroCuenta);

    @Query("SELECT new com.bancobisa.flujocaja.apiflujocajabisa.dto.CuentaDto( " +
            "c.cuentaId, c.numeroCuenta, c.clienteId, c.nombreCuenta, c.descripcion, c.moneda, c.saldo) " +
            "FROM CuentaEntity c " +
            "WHERE c.estadoId = 1000")
    public List<CuentaDto> buscarTodosLasCuentas();

    @Query("SELECT c " +
            "FROM CuentaEntity c " +
            "WHERE c.cuentaId = :pCuentaId and c.estadoId = 1000")
    public Optional<CuentaEntity> buscarCuentaPorCuentaId(Long pCuentaId);


}
