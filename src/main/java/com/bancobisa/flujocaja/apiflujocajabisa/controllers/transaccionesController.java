package com.bancobisa.flujocaja.apiflujocajabisa.controllers;

import com.bancobisa.flujocaja.apiflujocajabisa.dto.DatosClienteDto;
import com.bancobisa.flujocaja.apiflujocajabisa.dto.ResponseDto;
import com.bancobisa.flujocaja.apiflujocajabisa.dto.TransaccionDto;
import com.bancobisa.flujocaja.apiflujocajabisa.services.IDatosClienteService;
import com.bancobisa.flujocaja.apiflujocajabisa.services.ITransaccionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api")
public class transaccionesController {

    @Autowired
    private ITransaccionService iTransaccionService;

    @PostMapping("/v1/transaccion")
    public ResponseEntity<?> registrarTransaccion(@RequestBody TransaccionDto transaccionDto) {
        ResponseDto resp =  iTransaccionService.crearTransaccion(transaccionDto);
        return new ResponseEntity<ResponseDto>(resp, HttpStatus.OK);
    }


    @GetMapping("/v1/transaccion/verhistorico-por-cuenta/{pCuenta}")
    public ResponseEntity<?> verHistoricoTransaccionPorCuenta(@PathVariable String pCuenta) {
        ResponseDto resp =  iTransaccionService.historicoTransaccionPorCuenta(pCuenta);
        return new ResponseEntity<ResponseDto>(resp, HttpStatus.OK);
    }


}
