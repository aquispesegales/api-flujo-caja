package com.bancobisa.flujocaja.apiflujocajabisa.services;

import com.bancobisa.flujocaja.apiflujocajabisa.dto.CuentaDto;
import com.bancobisa.flujocaja.apiflujocajabisa.dto.ResponseDto;
import com.bancobisa.flujocaja.apiflujocajabisa.dto.TransaccionDto;

public interface ITransaccionService {
    public ResponseDto crearTransaccion (TransaccionDto transaccionDto);

    public ResponseDto historicoTransaccionPorCuenta (String pCuenta);

}
