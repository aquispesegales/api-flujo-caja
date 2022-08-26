package com.bancobisa.flujocaja.apiflujocajabisa.controllers;

import com.bancobisa.flujocaja.apiflujocajabisa.dto.CuentaDto;
import com.bancobisa.flujocaja.apiflujocajabisa.dto.DatosClienteDto;
import com.bancobisa.flujocaja.apiflujocajabisa.dto.ResponseDto;
import com.bancobisa.flujocaja.apiflujocajabisa.services.ICuentaService;
import com.bancobisa.flujocaja.apiflujocajabisa.services.IDatosClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api")
public class datosClienteController {

    @Autowired
    private IDatosClienteService iDatosClienteService;

    @PostMapping("/v1/cliente")
    public ResponseEntity<?> registrarCliente(@RequestBody DatosClienteDto datosClienteDto) {
        ResponseDto resp =  iDatosClienteService.crearDatosCliente(datosClienteDto);
        return new ResponseEntity<ResponseDto>(resp, HttpStatus.OK);
    }
}
