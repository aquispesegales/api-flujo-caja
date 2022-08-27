package com.bancobisa.flujocaja.apiflujocajabisa.dao;

import com.bancobisa.flujocaja.apiflujocajabisa.dto.HistoricoTransaccionDto;
import com.bancobisa.flujocaja.apiflujocajabisa.dto.TransaccionDto;
import com.bancobisa.flujocaja.apiflujocajabisa.entity.CuentaEntity;
import com.bancobisa.flujocaja.apiflujocajabisa.entity.TransaccionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ITransaccionDao extends JpaRepository<TransaccionEntity, Long> {


    @Query("SELECT new  com.bancobisa.flujocaja.apiflujocajabisa.dto.HistoricoTransaccionDto( " +
            " dc.nombres, dc.apPaterno, dc.apMaterno, c.numeroCuenta, t.ingreso,t.egreso,t.saldo, d.descripcion)"+
            " FROM TransaccionEntity t " +
            " INNER JOIN CuentaEntity c ON c.cuentaId = t.cuentaId"+
            " INNER JOIN DatosClienteEntity dc ON c.clienteId = dc.clienteId "+
            " INNER  JOIN DominioEntity d ON d.dominioId = t.tipoTransaccionId "+

            " where c.numeroCuenta = :pNroCuenta and t.estadoId=1000 and c.estadoId = 1000 and d.estadoId = 1000" )

    public List<HistoricoTransaccionDto> buscarTransaccionPorNroCuenta(@Param("pNroCuenta") String pNroCuenta);

    @Query(value = "select (sum(COALESCE (t.ingreso,0)) - sum(COALESCE (t.egreso, 0) ))  from bd_flujo_caja.cuenta.transacciones t  " +
            "where t.cuenta_id = :cuentaId and t.estado_id = 1000", nativeQuery = true)
    public Double obtenerSaldoPorCuentaId (@Param("cuentaId") Long cuentaId);
}
