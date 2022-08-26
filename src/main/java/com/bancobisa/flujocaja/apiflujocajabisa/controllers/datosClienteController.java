package com.bancobisa.flujocaja.apiflujocajabisa.controllers;

import com.bancobisa.flujocaja.apiflujocajabisa.dto.CuentaDto;
import com.bancobisa.flujocaja.apiflujocajabisa.dto.DatosClienteDto;
import com.bancobisa.flujocaja.apiflujocajabisa.dto.ResponseDto;
import com.bancobisa.flujocaja.apiflujocajabisa.services.ICuentaService;
import com.bancobisa.flujocaja.apiflujocajabisa.services.IDatosClienteService;
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
public class datosClienteController {

    @Autowired
    private IDatosClienteService iDatosClienteService;

    @PostMapping("/v1/cliente")
    public ResponseEntity<?> registrarCliente(@RequestBody DatosClienteDto datosClienteDto) {
        ResponseDto resp =  iDatosClienteService.crearDatosCliente(datosClienteDto);
        return new ResponseEntity<ResponseDto>(resp, HttpStatus.OK);
    }

    @GetMapping("/v1/cliente-todos")
    public ResponseEntity<?> obtenerTodosCliente() {
        Map<String, Object> response = new HashMap<>();
        ResponseDto result =  iDatosClienteService.obtenerTodosCliente();
        response.put("codigo", result.getCodigo());
        response.put("mensaje", result.getMensaje());
        if(result.getCodigo().equals(ConstDiccionarioMensajes.COD1000))
            response.put("listadoClientes", result.getElementoGenerico());

        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);

    }
}
