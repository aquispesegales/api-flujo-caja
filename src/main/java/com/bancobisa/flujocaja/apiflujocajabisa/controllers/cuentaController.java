package com.bancobisa.flujocaja.apiflujocajabisa.controllers;

import com.bancobisa.flujocaja.apiflujocajabisa.dto.CuentaDto;
import com.bancobisa.flujocaja.apiflujocajabisa.dto.ResponseDto;
import com.bancobisa.flujocaja.apiflujocajabisa.services.ICuentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api")
public class cuentaController {

    @Autowired
    private ICuentaService iCuentaService;

    @PostMapping("/v1/cuenta")
    public ResponseEntity<?> registrarCuenta(@RequestBody CuentaDto cuentaDto) {
        ResponseDto resp =  iCuentaService.crearCuenta(cuentaDto);
        return new ResponseEntity<ResponseDto>(resp, HttpStatus.OK);
    }

}
