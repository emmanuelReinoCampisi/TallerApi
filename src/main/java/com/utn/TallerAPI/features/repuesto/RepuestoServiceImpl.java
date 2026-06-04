package com.utn.TallerAPI.features.repuesto;

import com.utn.TallerAPI.Exception.BusinessException;
import com.utn.TallerAPI.Exception.ResourceNotFoundException;
import com.utn.TallerAPI.features.repuesto.dto.RepuestoRequest;
import com.utn.TallerAPI.features.repuesto.dto.RepuestoResponse;
import com.utn.TallerAPI.features.repuesto.mapper.RepuestoMapper;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RepuestoServiceImpl implements RepuestoService{


    private RepuestoRepository repuestoRepository;
    private RepuestoMapper repuestoMapper;


    @Override
    @Transactional
    public RepuestoResponse registrar(RepuestoRequest request) {
        if(repuestoRepository.existsByCodigo(request.getCodigoRepuesto())){
            throw new BusinessException("Ya existe un repuesto con este codigo");
        }
        RepuestoEntity r = repuestoMapper.toEntity(request);

        return repuestoMapper.toResponse(repuestoRepository.save(r));
    }

    @Override
    public RepuestoResponse obtenerPorId(Long id) {
        RepuestoEntity r = repuestoRepository.findById(id).
                orElseThrow(()-> new ResourceNotFoundException("No se encontro ningun repuesto con el id: "+id));
        return repuestoMapper.toResponse(r);
    }

    @Override
    @Transactional
    public RepuestoResponse actualizarStock(Long id, Integer nuevaCantidad) {

        RepuestoEntity repuesto = repuestoRepository.findById(id).
                orElseThrow(()-> new ResourceNotFoundException("No se encontro ningun repuesto con el id: "+id));
        if(nuevaCantidad < 0){
            throw new BusinessException("La cantidad no puede ser menor a 0");
        }
        repuesto.setStockActual(nuevaCantidad);
        return repuestoMapper.toResponse(repuestoRepository.save(repuesto));
    }

    @Override
    public List<RepuestoResponse> listarTodos() {
        return repuestoRepository.findAll().stream().
                map(repuestoMapper:: toResponse).
                collect(Collectors.toList());
    }

    @Override
    public List<RepuestoResponse> listarBajoStock() {
        return repuestoRepository.findBajoStock().stream().
                map(repuestoMapper:: toResponse).
                collect(Collectors.toList());
    }
}
