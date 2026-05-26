package com.utn.TallerAPI.features.finanzas.deuda;

import com.utn.TallerAPI.features.finanzas.deuda.dto.DeudaRequest;
import com.utn.TallerAPI.features.finanzas.deuda.dto.DeudaResponse;

public interface DeudaService {

    DeudaResponse obtenerPorClienteId(Integer clienteId);
    DeudaResponse ajustarDeudaManualmente(DeudaRequest request);
}
