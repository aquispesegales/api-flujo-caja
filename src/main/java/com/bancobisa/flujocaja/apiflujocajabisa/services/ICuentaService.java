package com.bancobisa.flujocaja.apiflujocajabisa.services;

import com.bancobisa.flujocaja.apiflujocajabisa.dto.CuentaDto;
import com.bancobisa.flujocaja.apiflujocajabisa.dto.ResponseDto;

public interface ICuentaService {
    public ResponseDto crearCuenta (CuentaDto cuentaDto);
}
