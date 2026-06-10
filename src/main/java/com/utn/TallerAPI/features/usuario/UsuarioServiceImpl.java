package com.utn.TallerAPI.features.usuario;

import com.utn.TallerAPI.Exception.BusinessException;
import com.utn.TallerAPI.Exception.ResourceNotFoundException;
import com.utn.TallerAPI.features.usuario.dto.UsuarioRequest;
import com.utn.TallerAPI.features.usuario.dto.UsuarioResponse;
import com.utn.TallerAPI.features.usuario.mapper.UsuarioMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl implements IusuarioService {

    private final UsuarioRepository usuarioRepository;
    private final UsuarioMapper usuarioMapper;
    private final PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public UsuarioResponse crearUsuario(UsuarioRequest request) {
        if (usuarioRepository.existsByUserName(request.getUsername())) {
            throw new BusinessException("El username ya existe");
        }
        if (usuarioRepository.existsByEmail(request.getEmail())) {
            throw new BusinessException("El email ya está registrado");
        }
        if (request.getDni() != null && usuarioRepository.existsByDNI(request.getDni())) {
            throw new BusinessException("El DNI ya está registrado");
        }

        UsuarioEntity usuario = usuarioMapper.toEntity(request);
        usuario.setPassword(passwordEncoder.encode(request.getPassword()));
        return usuarioMapper.toResponse(usuarioRepository.save(usuario));
    }

    @Override
    public UsuarioResponse obtenerPorId(Long id) {
        return usuarioMapper.toResponse(usuarioRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Usuario no encontrado con ID: " + id)));
    }

    @Override
    public List<UsuarioResponse> obtenerTodosUsuarios() {
        return usuarioMapper.toResponseList(usuarioRepository.findAll());
    }

    @Override
    @Transactional
    public UsuarioResponse actualizarUsuario(Long id, UsuarioRequest request) {
        UsuarioEntity usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Usuario no encontrado con ID: " + id));

        if (!usuario.getUserName().equals(request.getUsername()) && usuarioRepository.existsByUserName(request.getUsername())) {
            throw new BusinessException("El username ya está en uso");
        }
        if (!usuario.getEmail().equals(request.getEmail()) && usuarioRepository.existsByEmail(request.getEmail())) {
            throw new BusinessException("El email ya está en uso");
        }

        usuarioMapper.updateEntity(usuario, request);
        return usuarioMapper.toResponse(usuarioRepository.save(usuario));
    }

    @Override
    @Transactional
    public void eliminarUsuario(Long id) {
        if (!usuarioRepository.existsById(id)) {
            throw new ResourceNotFoundException("Usuario no encontrado con ID: " + id);
        }
        usuarioRepository.deleteById(id);
    }
}