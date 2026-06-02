package com.utn.TallerAPI.features.vehiculo.mapper;

import com.utn.TallerAPI.features.vehiculo.VehiculoEntity;
import com.utn.TallerAPI.features.vehiculo.dto.VehiculoRequest;
import com.utn.TallerAPI.features.vehiculo.dto.VehiculoResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import java.util.List;
import lombok.*;

@Mapper(componentModel = "spring")
 public abstract class VehiculoMapper {

    public VehiculoEntity toEntity(VehiculoRequest request){
            if(request == null){return null;}
           VehiculoEntity vehiculo = new VehiculoEntity();

            vehiculo.setPatente(request.patente());
            vehiculo.setMarca(request.marca());
            vehiculo.setModelo(request.modelo());

            return vehiculo;
    }

    VehiculoResponse toResponse(VehiculoEntity vehiculo){
        if(vehiculo == null){
            return null;
        }
        VehiculoResponse response = new VehiculoResponse();
        response.setId(vehiculo.getId());

    }

    List<VehiculoResponse> toResponseList(List<VehiculoEntity> vehiculos){


    }

}