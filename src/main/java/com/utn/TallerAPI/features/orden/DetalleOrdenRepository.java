package com.utn.TallerAPI.features.orden;

import java.util.List;

public interface DetalleOrdenRepository {
    List<DetalleOrden> findByOrdenId(Long ordenId);
}
