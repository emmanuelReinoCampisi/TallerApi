package com.utn.TallerAPI.features.turno.mapper;

import com.utn.TallerAPI.features.turno.TurnoEntity;
import com.utn.TallerAPI.features.turno.dto.TurnoResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.ArrayList;
import java.util.List;

@Mapper(componentModel = "spring")
public abstract class TurnoMapper {


    TurnoResponse toResponse(TurnoEntity turno){

        TurnoResponse response= new TurnoResponse();

        if(turno == null) return  null;

        response.setId(turno.getId());
        response.getFechaYhoraIngreso(turno.getFechaYhoraIngreso());
        if(turno.getEstado() != null){
            response.setEstado(turno.getEstado().name());
        }

        if(turno.getClienteId() != null){ /// verificar que el cliente exista
            response.setClienteId(turno.getClienteId());
            if(turno.getNombreCliente() != null){
                response.setNombreCliente(turno.getNombreCliente());
            }
        }

        if(turno.getVehiculoId() != null){ ///  verificar que el vehiculo exista
            response.setVehiculoId(turno.getVehiculoId());
            if (turno.getPatenteVehiculo() != null){ ///  validar la patente
                response.setPatenteVehiculo(turno.getPatenteVehiculo());
            }
        }

        if(turno.getCreadoPor() != null){ ///  validar quien lo creo

            response.setCreadoPor(turno.getCreadoPor().getNombre()+""+turno.getCreadoPor().getApellido());
        }
        return response;
    }
    List<TurnoResponse> toResponseList(List<TurnoEntity> turnos){
            if(turnos == null) return null;

            List<TurnoResponse> list = new ArrayList<>();

            for(TurnoEntity t : turnos){
                list.add(this.toResponse(t));
            }

            return list;
    }

}
