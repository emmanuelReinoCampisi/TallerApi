package com.utn.TallerAPI.features.mecanico;

import com.utn.TallerAPI.Exception.BusinessException;
import com.utn.TallerAPI.Exception.ResourceNotFoundException;
import com.utn.TallerAPI.features.mecanico.dto.EspecialidadRequest;
import com.utn.TallerAPI.features.mecanico.dto.EspecialidadResponse;
import com.utn.TallerAPI.features.mecanico.dto.MecanicoRequest;
import com.utn.TallerAPI.features.mecanico.dto.MecanicoResponse;
import com.utn.TallerAPI.features.mecanico.mapper.MecanicoMapper;
import com.utn.TallerAPI.features.usuario.UsuarioRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MecanicoService implements ImecanicoSerivice{

    private final ImecanicoRepository mecanicoRepository;
    private final EspecialidadRepository especialidadRepository;
    private final UsuarioRepository usuarioRepository;
    private final MecanicoMapper mecanicoMapper;
    private final ThreadPoolTaskExecutor threadPoolTaskExecutor;

    @Override
    @Transactional
    public MecanicoResponse crear(MecanicoRequest request) {
        if (mecanicoRepository.existsByLegajo(request.legajo())) {
            throw new BusinessException("Ya existe un mecanico con este legajo");
        }

        MecanicoEntity mecanico = MecanicoEntity.builder()
                .usuario(request.usuarioId() != null
                        ? usuarioRepository.findById(request.usuarioId())
                        .orElseThrow(() -> new ResourceNotFoundException("Usuario no encontrado"))

                        : null)
                .legajo(request.legajo())
                .salario(request.sueldo())
                .fechaIngreso(request.fechaIngreso())
                .activo(true)
                .build();
        if (request.especialidadIds() != null) {
            List<Especialidad> especialidades = request.especialidadIds().stream()
                    .map(eid ->  especialidadRepository.findById(eid)
                            .orElseThrow(() -> new ResourceNotFoundException("Especialidad no encontrada: "+eid)))
                    .collect(Collectors.toList());
            mecanico.setEspecialidades(especialidades);
        }
        return mecanicoMapper.toResponse(mecanicoRepository.save(mecanico));


    }

    @Override
    public MecanicoResponse obtenerPorId(Long id) {
        return mecanicoMapper.toResponse(mecanicoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Mecanico no encontrado")));
    }

    @Override
    public List<MecanicoResponse> listarActivos() {
        return mecanicoMapper.toResponseList(mecanicoRepository.findAllActivos());
    }

    @Override
    @Transactional
    public MecanicoResponse actualizar(Long id, MecanicoRequest request) {
        MecanicoEntity mecanico = mecanicoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Mecánico no encontrado con ID: " + id));

        if (!mecanico.getLegajo().equals(request.legajo()) &&
                mecanicoRepository.existsByLegajo(request.legajo())) {
            throw new BusinessException("El nuevo legajo ya está asignado a otro mecánico");
        }


        mecanico.setSalario(request.sueldo());
        mecanico.setFechaIngreso(request.fechaIngreso());
        mecanico.setLegajo(request.legajo());

        if (request.especialidadIds() != null) {
            List<Especialidad> nuevasEspecialidades = request.especialidadIds().stream()
                    .map(eid -> especialidadRepository.findById(eid)
                            .orElseThrow(() -> new ResourceNotFoundException("Especialidad no encontrada: " + eid)))
                    .collect(Collectors.toList());
            mecanico.setEspecialidades(nuevasEspecialidades);
        }

        return mecanicoMapper.toResponse(mecanicoRepository.save(mecanico));
    }

    @Override
    @Transactional
    public MecanicoResponse asignarEspecialidades(Long id, List<Long> IdsEspecialidades) {
        MecanicoEntity mecanico = mecanicoRepository.findByUsuarioId(id).orElseThrow(() -> new ResourceNotFoundException("Mecanico no encontrado"));
        if (IdsEspecialidades == null || IdsEspecialidades.isEmpty()) {
            mecanico.setEspecialidades(new ArrayList<>());
        } else {
            List<Especialidad> especialidades = especialidadRepository.findAllIds(IdsEspecialidades);
            if (especialidades.size() != IdsEspecialidades.size()) {
                throw new BusinessException("Una o más especialidades no existen");
            }
            mecanico.setEspecialidades(especialidades);
        }
        return mecanicoMapper.toResponse(mecanicoRepository.save(mecanico));
    }

    @Override
    @Transactional
    public void desactivarMecanico(Long id) {
        MecanicoEntity mecanico = mecanicoRepository.findByUsuarioId(id).orElseThrow(() -> new ResourceNotFoundException("Mecanico no encontrado"));
        mecanico.setActivo(false);
        mecanicoRepository.save(mecanico);
    }

    @Override
    public List<MecanicoResponse> listarPorEspecialidad(Long IdEspecialidad) {
            return mecanicoMapper.toResponseList(mecanicoRepository.findByEspecialidadesId(IdEspecialidad));
    }

    @Override
    @Transactional
    public EspecialidadResponse crearEspecialidad(EspecialidadRequest request) {
        if(especialidadRepository.existsByNombre(request.nombre())) {
            throw new BusinessException("Esta especialidad ya existe con el nombre: " + request.nombre());
        }
        Especialidad especialidad = Especialidad.builder()
                .nombreEspecialidad(request.nombre())
                .build();

        return mecanicoMapper.toEspecialidadResponse(especialidadRepository.save(especialidad));
    }

    @Override
    public List<EspecialidadResponse> listarEspecialidades() {
        return List.of();
    }

    @Override
    public EspecialidadResponse obtenerEspecialidadPorId(Long id) {
        return mecanicoMapper.toEspecialidadResponse(especialidadRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Especialidad no encontrado")));
    }

    @Override
    @Transactional
    public void eliminarEspecialidad(Long id) {
        Especialidad esp = especialidadRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Especialidad no encontrada"));
        if (!esp.getMecanicos().isEmpty()) {
            throw new BusinessException("No se puede eliminar una especialidad con mecánicos asignados");
        }
        especialidadRepository.deleteById(id);
    }


}
