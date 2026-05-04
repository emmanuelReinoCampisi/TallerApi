package com.utn.TallerAPI.features.orden;

import com.utn.TallerAPI.features.cliente.TipoCliente;
import com.utn.TallerAPI.features.mecanico.EspecialidadRepository;
import com.utn.TallerAPI.features.orden.mapper.OrdenMapper;

import java.util.Map;

public class OrdenServiceImpl extends OrdenService{
    private final OrdenTrabajoRepository ordenTrabajoRepository;
    private final DetalleOrdenRepository detalleOrdenRepository;
    private final OrdenMecanicoRepository ordenMecanicoRepository;
    private final TurnoRepository turnoRepository;
    private final RepuestoRepository repuestoRepository;
    private final RepuestoService repuestoService;
    private final MecanicoRepository mecanicoRepository;
    private final EspecialidadRepository especialidadRepository;
    private final HistorialVehiculoRepository historialVehiculoRepository;
    private final OrdenMapper ordenMapper;

}
