package com.bancobisa.flujocaja.apiflujocajabisa.controllers;

import com.bancobisa.flujocaja.apiflujocajabisa.dto.ResponseDto;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/reportes")
public class reportesController {

    @GetMapping("/v1/transacciones-por-cuenta/{pCuenta}")
    public ResponseDto obtenerHistoricoTransaccion(@PathVariable String pCuenta){
        ResponseDto resp = new ResponseDto();
        resp.setCodigo("1000");
        resp.setMensaje("Mensaje :"+pCuenta);
        return resp;
    }
}
