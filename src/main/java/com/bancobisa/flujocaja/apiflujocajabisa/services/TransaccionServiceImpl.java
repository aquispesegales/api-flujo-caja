package com.bancobisa.flujocaja.apiflujocajabisa.services;

import com.bancobisa.flujocaja.apiflujocajabisa.dao.ICuentaDao;
import com.bancobisa.flujocaja.apiflujocajabisa.dao.IDatosClienteDao;
import com.bancobisa.flujocaja.apiflujocajabisa.dao.ITransaccionDao;
import com.bancobisa.flujocaja.apiflujocajabisa.dto.HistoricoTransaccionDto;
import com.bancobisa.flujocaja.apiflujocajabisa.dto.ResponseDto;
import com.bancobisa.flujocaja.apiflujocajabisa.dto.TransaccionDto;
import com.bancobisa.flujocaja.apiflujocajabisa.entity.CuentaEntity;
import com.bancobisa.flujocaja.apiflujocajabisa.entity.TransaccionEntity;
import com.bancobisa.flujocaja.apiflujocajabisa.utils.constantes.ConstDiccionarioMensajes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class TransaccionServiceImpl implements ITransaccionService {

    @Autowired
    private ITransaccionDao iTransaccionDao;

    @Autowired
    private ICuentaDao iCuentaDao;

    @Transactional
    @Override
    public ResponseDto crearTransaccion(TransaccionDto transaccionDto) {
        ResponseDto resp = new ResponseDto();
        try{

            Optional<CuentaEntity> cuenta =  iCuentaDao.buscarCuentaPorCuentaId(transaccionDto.getCuentaId());
            if(!cuenta.isPresent()){
                resp.setCodigo("COD_1001");
                resp.setMensaje("no existe la cuentaId = "+transaccionDto.getCuentaId());
                return resp;
            }
            TransaccionEntity objInsert = new TransaccionEntity();
            objInsert.setCuentaId(transaccionDto.getCuentaId());
            objInsert.setDetalle(transaccionDto.getDetalle());
            objInsert.setIngreso(transaccionDto.getIngreso());
            objInsert.setEgreso(transaccionDto.getEgreso());
            objInsert.setSaldo(transaccionDto.getSaldo());
            objInsert.setTipoTransaccionId(transaccionDto.getTipoTransaccionId());
            objInsert.setFechaRegistro(new Date());
            objInsert.setEstadoId(1000L);
            iTransaccionDao.save(objInsert);
            resp.setCodigo(ConstDiccionarioMensajes.COD1000);
            resp.setMensaje(ConstDiccionarioMensajes.COD1000_MENSAJE);

        }catch (Exception ex){
            resp.setCodigo("COD_1001");
            resp.setMensaje("Error Técnico");
        }
        return resp;
    }

    @Override
    public ResponseDto historicoTransaccionPorCuenta(String pCuenta) {
        ResponseDto resp = new ResponseDto();
        try{
            List<HistoricoTransaccionDto> historicoTransaccionDto =  iTransaccionDao.buscarTransaccionPorNroCuenta(pCuenta);
            if(historicoTransaccionDto.size()==0){
                resp.setCodigo("COD_1001");
                resp.setMensaje("No se enocntraron transacciones para la cuenta = "+pCuenta);
                return resp;
            }
            resp.setCodigo("COD_1000");
            resp.setMensaje("historicos encotrados");
            resp.setElementoGenerico(historicoTransaccionDto);


        }catch (Exception ex){
            resp.setCodigo("COD_1001");
            resp.setMensaje("Error Técnico");
        }
        return resp;
    }
}
