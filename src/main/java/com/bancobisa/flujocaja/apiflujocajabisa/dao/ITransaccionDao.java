package com.bancobisa.flujocaja.apiflujocajabisa.dao;

import com.bancobisa.flujocaja.apiflujocajabisa.entity.CuentaEntity;
import com.bancobisa.flujocaja.apiflujocajabisa.entity.TransaccionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITransaccionDao extends JpaRepository<TransaccionEntity, Long> {
    
}
