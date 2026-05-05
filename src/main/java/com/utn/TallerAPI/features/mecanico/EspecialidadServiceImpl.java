package com.utn.TallerAPI.features.Mecanico;

import com.utn.TallerAPI.Exception.BusinessException;
import com.utn.TallerAPI.Exception.ResourceNotFoundException;
import com.utn.TallerAPI.features.Mecanico.DTO.EspecialidadRequest;
import com.utn.TallerAPI.features.Mecanico.DTO.EspecialidadResponse;
import com.utn.TallerAPI.features.Mecanico.Mapper.EspecialidadMapper;
import com.utn.TallerAPI.features.mecanico.Especialidad;
import com.utn.TallerAPI.features.mecanico.EspecialidadRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class EspecialidadServiceImpl implements EspecialidadService {

    private final EspecialidadRepository especialidadRepository;
    private final EspecialidadMapper  especialidadMapper;

    public EspecialidadServiceImpl(EspecialidadRepository especialidadRepository, EspecialidadMapper especialidadMapper) {
        this.especialidadRepository = especialidadRepository;
        this.especialidadMapper = especialidadMapper;
    }

    @Override
    @Transactional
    public EspecialidadResponse crear(EspecialidadRequest request) {
        if (especialidadRepository.existsByNombre(request.nombre())) {
            throw new BusinessException("Ya existe una especialidad con ese nombre");
        }

        Especialidad especialidad = especialidadMapper.toEntity(request);
        return especialidadMapper.toResponse(especialidadRepository.save(especialidad));
    }

    @Override
    @Transactional(readOnly = true)
    public List<EspecialidadResponse> listarTodas() {
        return especialidadMapper.toResponseList(especialidadRepository.findAll());
    }


    @Override
    @Transactional(readOnly = true)
    public EspecialidadResponse obtenerPorId(Long id) {
        Especialidad especialidad = especialidadRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Especialidad no encontrada"));
        return especialidadMapper.toResponse(especialidad);
    }

    @Override
    @Transactional
    public void eliminar(Long id) {
        Especialidad especialidad = especialidadRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Especialidad no encontrada"));

        if (!especialidad.getMecanicos().isEmpty()) {
            throw new BusinessException("No se puede eliminar una especialidad con mecánicos asignados");
        }

        especialidadRepository.delete(especialidad);
    }
}
