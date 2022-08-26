package com.bancobisa.flujocaja.apiflujocajabisa.controllers;

import com.bancobisa.flujocaja.apiflujocajabisa.dto.CuentaDto;
import com.bancobisa.flujocaja.apiflujocajabisa.dto.ResponseDto;
import com.bancobisa.flujocaja.apiflujocajabisa.services.ICuentaService;
import com.bancobisa.flujocaja.apiflujocajabisa.utils.constantes.ConstDiccionarioMensajes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
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
        String saldo = resp.getElementoGenerico()!=null?(String)resp.getElementoGenerico():"0.00";
        resp.setElementoGenerico(saldo);
        return new ResponseEntity<ResponseDto>(resp, HttpStatus.OK);
    }

    @GetMapping("/v1/saldo-por-nrocuenta/{pNroCuenta}")
    public ResponseEntity<?> buscarSaldoPorNroCuenta(@PathVariable String pNroCuenta) {
        Map<String, Object> response = new HashMap<>();
        ResponseDto result =  iCuentaService.saldoPorNroCuenta(pNroCuenta);
        response.put("codigo", result.getCodigo());
        response.put("mensaje", result.getMensaje());
        if(result.getCodigo().equals(ConstDiccionarioMensajes.COD1000))
            response.put("saldo", result.getElementoGenerico());
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
    }

    @GetMapping("/v1/cuentas-todos")
    public ResponseEntity<?> obtenerTodosCuentas() {
        Map<String, Object> response = new HashMap<>();
        ResponseDto result =  iCuentaService.obtenerTodosCuentas();
        response.put("codigo", result.getCodigo());
        response.put("mensaje", result.getMensaje());
        if(result.getCodigo().equals(ConstDiccionarioMensajes.COD1000))
            response.put("listadoCuentas", result.getElementoGenerico());

        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);

    }


}
