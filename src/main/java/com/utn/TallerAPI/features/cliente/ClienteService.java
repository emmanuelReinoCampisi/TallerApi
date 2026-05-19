package com.utn.TallerAPI.features.cliente;

import com.utn.TallerAPI.features.cliente.dto.ClienteRequest;
import com.utn.TallerAPI.features.cliente.dto.ClienteResponse;

import java.util.List;

public interface ClienteService {

    ClienteResponse crear(ClienteRequest clienteRequest);
    ClienteResponse obtenerPorID(Integer id);
   List<ClienteResponse> obtenerTodosClientes();
}
