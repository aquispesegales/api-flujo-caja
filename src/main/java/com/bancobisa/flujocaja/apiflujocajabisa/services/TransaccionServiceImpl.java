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
                resp.setCodigo(ConstDiccionarioMensajes.COD1002);
                resp.setMensaje(ConstDiccionarioMensajes.COD1002_MENSAJE+ " para = "+transaccionDto.getCuentaId());
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

            // Actualiza saldo
            Double saldo =  iTransaccionDao.obtenerSaldoPorCuentaId(transaccionDto.getCuentaId());
            CuentaEntity updateCuenta = iCuentaDao.buscarCuentaPorCuentaId(transaccionDto.getCuentaId()).get();
            updateCuenta.setSaldo(saldo);
            iCuentaDao.save(updateCuenta);

            resp.setCodigo(ConstDiccionarioMensajes.COD1000);
            resp.setMensaje(ConstDiccionarioMensajes.COD1000_MENSAJE);

        }catch (Exception ex){
            resp.setCodigo(ConstDiccionarioMensajes.COD1001);
            resp.setMensaje(ConstDiccionarioMensajes.COD1001_MENSAJE);
        }
        return resp;
    }

    @Override
    public ResponseDto historicoTransaccionPorCuenta(String pCuenta) {
        ResponseDto resp = new ResponseDto();
        try{
            List<HistoricoTransaccionDto> historicoTransaccionDto =  iTransaccionDao.buscarTransaccionPorNroCuenta(pCuenta);
            if(historicoTransaccionDto.size()==0){
                resp.setCodigo(ConstDiccionarioMensajes.COD1004);
                resp.setMensaje(ConstDiccionarioMensajes.COD1004_MENSAJE + " para la cuenta = "+pCuenta);
                return resp;
            }
            resp.setCodigo(ConstDiccionarioMensajes.COD1000);
            resp.setMensaje(ConstDiccionarioMensajes.COD1000_MENSAJE);
            resp.setElementoGenerico(historicoTransaccionDto);


        }catch (Exception ex){
            resp.setCodigo(ConstDiccionarioMensajes.COD1001);
            resp.setMensaje(ConstDiccionarioMensajes.COD1001_MENSAJE);
        }
        return resp;
    }
}
