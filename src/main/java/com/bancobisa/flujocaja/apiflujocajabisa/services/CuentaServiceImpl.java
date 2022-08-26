package com.bancobisa.flujocaja.apiflujocajabisa.services;

import com.bancobisa.flujocaja.apiflujocajabisa.dao.ICuentaDao;
import com.bancobisa.flujocaja.apiflujocajabisa.dto.CuentaDto;
import com.bancobisa.flujocaja.apiflujocajabisa.dto.ResponseDto;
import com.bancobisa.flujocaja.apiflujocajabisa.entity.CuentaEntity;
import com.bancobisa.flujocaja.apiflujocajabisa.utils.constantes.ConstDiccionarioMensajes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
public class CuentaServiceImpl implements ICuentaService {

    @Autowired
    private ICuentaDao iCuentaDao;

    @Override
    @Transactional
    public ResponseDto crearCuenta(CuentaDto cuentaDto) {
        ResponseDto resp = new ResponseDto();
        try{
            CuentaEntity objInsert = new CuentaEntity();
            objInsert.setNumeroCuenta( (Math.random()*100000)+""); // genera nro de cuenta aleatorio
            objInsert.setClienteId(cuentaDto.getClienteId());
            objInsert.setNombreCuenta(cuentaDto.getNombreCuenta());
            objInsert.setDescripcion(cuentaDto.getDescripcion());
            objInsert.setSaldo(0.00);
            objInsert.setMoneda(1000L); // siempre Bs
            objInsert.setFechaRegistro(new Date());
            objInsert.setEstadoId(1000L);
            iCuentaDao.save(objInsert);

            resp.setCodigo(ConstDiccionarioMensajes.COD1000);
            resp.setMensaje(ConstDiccionarioMensajes.COD1000_MENSAJE);

        }catch (Exception ex){
            resp.setCodigo("COD_1001");
            resp.setMensaje("Error Técnico");
        }
        return resp;
    }
}
