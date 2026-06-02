package com.utn.TallerAPI.features.vehiculo.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@NoArgsConstructor
@Getter
@Setter
public class VehiculoResponse{

    private Long id;
    private Long clienteId;
    private  String nombreCliente;
    private String patente;
    private String marca;
    private String modelo;
    private Integer anio;
    private String color;
    private Integer kilometraje;
    private  String estadoEnTaller;
    private   boolean esPropio;


}
