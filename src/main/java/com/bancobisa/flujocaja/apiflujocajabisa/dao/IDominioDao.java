package com.bancobisa.flujocaja.apiflujocajabisa.dao;

import com.bancobisa.flujocaja.apiflujocajabisa.entity.CuentaEntity;
import com.bancobisa.flujocaja.apiflujocajabisa.entity.DominioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDominioDao extends JpaRepository<DominioEntity, Long> {
    
}
