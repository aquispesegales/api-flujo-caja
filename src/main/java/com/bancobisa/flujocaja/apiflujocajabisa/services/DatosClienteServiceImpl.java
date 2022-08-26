package com.bancobisa.flujocaja.apiflujocajabisa.services;

import com.bancobisa.flujocaja.apiflujocajabisa.dao.ICuentaDao;
import com.bancobisa.flujocaja.apiflujocajabisa.dao.IDatosClienteDao;
import com.bancobisa.flujocaja.apiflujocajabisa.dto.CuentaDto;
import com.bancobisa.flujocaja.apiflujocajabisa.dto.DatosClienteDto;
import com.bancobisa.flujocaja.apiflujocajabisa.dto.ResponseDto;
import com.bancobisa.flujocaja.apiflujocajabisa.entity.CuentaEntity;
import com.bancobisa.flujocaja.apiflujocajabisa.entity.DatosClienteEntity;
import com.bancobisa.flujocaja.apiflujocajabisa.utils.constantes.ConstDiccionarioMensajes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class DatosClienteServiceImpl implements IDatosClienteService {

    @Autowired
    private IDatosClienteDao iDatosClienteDao;

    @Transactional
    @Override
    public ResponseDto crearDatosCliente(DatosClienteDto datosClienteDto) {
        ResponseDto resp = new ResponseDto();
        try{

            DatosClienteEntity objInsert = new DatosClienteEntity();
            objInsert.setCodigoCliente("COD_"+datosClienteDto.getCi()); // genera nro de cuenta aleatorio

            objInsert.setNombres   (datosClienteDto.getNombres());
            objInsert.setApPaterno(datosClienteDto.getApPaterno());
            objInsert.setApMaterno(datosClienteDto.getApMaterno());
            objInsert.setCi(datosClienteDto.getCi());
            objInsert.setDireccion(datosClienteDto.getDireccion());
            objInsert.setFechaRegistro(new Date());
            objInsert.setEstadoId(1000L);
            iDatosClienteDao.save(objInsert);

            resp.setCodigo(ConstDiccionarioMensajes.COD1000);
            resp.setMensaje(ConstDiccionarioMensajes.COD1000_MENSAJE);

        }catch (Exception ex){
            resp.setCodigo("COD_1001");
            resp.setMensaje("Error Técnico");

            //.... SE DEBE REGISTRAR LOG EN LA TABLA DE LOG, POR TEMAS DE TIEMPO NO PUDE COMPLETAR
        }
        return resp;
    }


    @Override
    public ResponseDto obtenerTodosCliente() {
        ResponseDto resp = new ResponseDto();
        try{

            List<DatosClienteDto> lstClientes =  iDatosClienteDao.buscarTodosLosClientes();
            if(lstClientes.size()==0){
                resp.setCodigo("COD_1001");
                resp.setMensaje("No existe Clientes");
                return resp;
            }
            resp.setCodigo(ConstDiccionarioMensajes.COD1000);
            resp.setMensaje(ConstDiccionarioMensajes.COD1000_MENSAJE);
            resp.setElementoGenerico(lstClientes);

        }catch (Exception ex){
            resp.setCodigo("COD_1001");
            resp.setMensaje("Error Técnico");

            //.... SE DEBE REGISTRAR LOG EN LA TABLA DE LOG, POR TEMAS DE TIEMPO NO PUDE COMPLETAR
        }
        return resp;
    }
}
