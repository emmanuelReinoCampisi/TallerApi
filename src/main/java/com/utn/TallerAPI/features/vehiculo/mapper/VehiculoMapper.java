package com.utn.TallerAPI.features.vehiculo.mapper;

import com.utn.TallerAPI.features.vehiculo.VehiculoEntity;
import com.utn.TallerAPI.features.vehiculo.dto.VehiculoRequest;
import com.utn.TallerAPI.features.vehiculo.dto.VehiculoResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.ArrayList;
import java.util.List;
import lombok.*;

@Mapper(componentModel = "spring")
 public abstract class VehiculoMapper {

    public VehiculoEntity toEntity(VehiculoRequest request){
            if(request == null){return null;}
           VehiculoEntity vehiculo = new VehiculoEntity();

            vehiculo.setPatente(request.getPatente());
            vehiculo.setMarca(request.getMarca());
            vehiculo.setModelo(request.getModelo());

            return vehiculo;
    }

   public VehiculoResponse toResponse(VehiculoEntity vehiculo){
        if(vehiculo == null){
            return null;
        }
        VehiculoResponse response = new VehiculoResponse();
        response.setId(vehiculo.getId());
        response.setPatente(vehiculo.getPatente());
        response.setMarca(vehiculo.getMarca());
        response.setModelo(vehiculo.getModelo());

        if(response.getEstadoEnTaller() != null){
            response.setEstadoEnTaller(vehiculo.getEstado().name());
        }

        if(response.getClienteId() != null){
            response.setClienteId(vehiculo.getCliente().getId());
            if(vehiculo.getCliente().getUsuario() != null){
                String nombreCompleto = vehiculo.getCliente().getUsuario().getNombre()+""+
                        vehiculo.getCliente().getUsuario().getApellido().trim();
                response.setNombreCliente(nombreCompleto);
            }else {
                response.setNombreCliente("Vehiculo Propio del Taller");
            }
        }

        return response;
    }

    List<VehiculoResponse> toResponseList(List<VehiculoEntity> vehiculos){
        if(vehiculos == null)return null;

        List<VehiculoResponse> list = new ArrayList<>();

        for(VehiculoEntity v : vehiculos){ ///  para cada vehiculo de la lista
            list.add(this.toResponse(v)); /// agregalo a la lista VehiculoResponse
        }
        return list;
    }

}