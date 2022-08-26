package com.bancobisa.flujocaja.apiflujocajabisa.dao;

import com.bancobisa.flujocaja.apiflujocajabisa.entity.DominioEntity;
import com.bancobisa.flujocaja.apiflujocajabisa.entity.LogErroresEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ILogErrorDao extends JpaRepository<LogErroresEntity, Long> {
}
