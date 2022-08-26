package com.bancobisa.flujocaja.apiflujocajabisa.services;

import com.bancobisa.flujocaja.apiflujocajabisa.dto.CuentaDto;
import com.bancobisa.flujocaja.apiflujocajabisa.dto.DatosClienteDto;
import com.bancobisa.flujocaja.apiflujocajabisa.dto.ResponseDto;

public interface IDatosClienteService {
    public ResponseDto crearDatosCliente (DatosClienteDto datosClienteDto);
    public ResponseDto obtenerTodosCliente ();

}
