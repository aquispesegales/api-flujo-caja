package com.bancobisa.flujocaja.apiflujocajabisa.dao;

import com.bancobisa.flujocaja.apiflujocajabisa.dto.DatosClienteDto;
import com.bancobisa.flujocaja.apiflujocajabisa.entity.CuentaEntity;
import com.bancobisa.flujocaja.apiflujocajabisa.entity.DatosClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface IDatosClienteDao extends JpaRepository<DatosClienteEntity, Long> {

    @Query("SELECT dc " +
            "FROM DatosClienteEntity dc " +
            "WHERE dc.clienteId = :pClienteId AND dc.estadoId = 1000")
    public Optional<DatosClienteEntity> buscarClientePorClienteId(@Param("pClienteId") Long pClienteId);

    @Query("SELECT new com.bancobisa.flujocaja.apiflujocajabisa.dto.DatosClienteDto( " +
            "dc.clienteId, dc.codigoCliente, dc.nombres, dc.apPaterno, dc.apMaterno, dc.ci, dc.direccion, dc.fechaRegistro, dc.estadoId) " +
            "FROM DatosClienteEntity dc " +
            "WHERE dc.estadoId = 1000")
    public List<DatosClienteDto> buscarTodosLosClientes();


}
