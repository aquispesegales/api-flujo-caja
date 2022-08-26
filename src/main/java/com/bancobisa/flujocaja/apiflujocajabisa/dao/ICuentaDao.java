package com.bancobisa.flujocaja.apiflujocajabisa.dao;

import com.bancobisa.flujocaja.apiflujocajabisa.entity.CuentaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICuentaDao extends JpaRepository<CuentaEntity, Long> {

}
