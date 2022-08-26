package com.bancobisa.flujocaja.apiflujocajabisa.services;

import com.bancobisa.flujocaja.apiflujocajabisa.dao.ICuentaDao;
import com.bancobisa.flujocaja.apiflujocajabisa.dao.IDatosClienteDao;
import com.bancobisa.flujocaja.apiflujocajabisa.dto.CuentaDto;
import com.bancobisa.flujocaja.apiflujocajabisa.dto.ResponseDto;
import com.bancobisa.flujocaja.apiflujocajabisa.entity.CuentaEntity;
import com.bancobisa.flujocaja.apiflujocajabisa.entity.DatosClienteEntity;
import com.bancobisa.flujocaja.apiflujocajabisa.utils.constantes.ConstDiccionarioMensajes;
import org.apache.catalina.LifecycleState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class CuentaServiceImpl implements ICuentaService {

    @Autowired
    private ICuentaDao iCuentaDao;

    @Autowired
    private IDatosClienteDao iDatosClienteDao;

    @Override
    @Transactional
    public ResponseDto crearCuenta(CuentaDto cuentaDto) {
        ResponseDto resp = new ResponseDto();
        try{

            Optional<DatosClienteEntity> datosClienteEntity =  iDatosClienteDao.buscarClientePorClienteId(cuentaDto.getClienteId());
            if (!datosClienteEntity.isPresent()){
                resp.setCodigo("COD_1001");
                resp.setMensaje("No existe el cliente = "+cuentaDto.getClienteId());
                return resp;
            }

            CuentaEntity objInsert = new CuentaEntity();
            objInsert.setNumeroCuenta(( (Math.random()*100000)+"").replace(".","")); // genera nro de cuenta aleatorio
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

    @Override
    public ResponseDto saldoPorNroCuenta(String pNroCuenta) {

        ResponseDto resp = new ResponseDto();
        try{
            pNroCuenta = pNroCuenta.trim();
            Double saldo = iCuentaDao.buscarSaldoPorNroCuenta(pNroCuenta);
            if(saldo==null){
                resp.setCodigo(ConstDiccionarioMensajes.  COD1002);
                resp.setMensaje(ConstDiccionarioMensajes.COD1002_MENSAJE);
                return resp;
            }

            resp.setCodigo(ConstDiccionarioMensajes.COD1000);
            resp.setMensaje(ConstDiccionarioMensajes.COD1000_MENSAJE);
            resp.setElementoGenerico(saldo);

        }catch (Exception ex){
            resp.setCodigo("COD_1001");
            resp.setMensaje("Error Técnico");
        }
        return resp;
    }

    @Override
    public ResponseDto obtenerTodosCuentas() {
        ResponseDto resp = new ResponseDto();
        try{

            List<CuentaDto> lstCuentaDto = iCuentaDao.buscarTodosLasCuentas();
            if(lstCuentaDto.isEmpty()){
                resp.setCodigo(ConstDiccionarioMensajes.  COD1002);
                resp.setMensaje(ConstDiccionarioMensajes.COD1002_MENSAJE);
                return resp;
            }

            resp.setCodigo(ConstDiccionarioMensajes.COD1000);
            resp.setMensaje(ConstDiccionarioMensajes.COD1000_MENSAJE);
            resp.setElementoGenerico(lstCuentaDto);

        }catch (Exception ex){
            resp.setCodigo("COD_1001");
            resp.setMensaje("Error Técnico");
        }
        return resp;
    }
}
