package com.utn.TallerAPI.features.cliente;

import com.utn.TallerAPI.Exception.BusinessException;
import com.utn.TallerAPI.Exception.ResourceNotFoundException;
import com.utn.TallerAPI.features.cliente.dto.ClienteRequest;
import com.utn.TallerAPI.features.cliente.dto.ClienteResponse;
import com.utn.TallerAPI.features.cliente.mapper.ClienteMapper;
import com.utn.TallerAPI.features.usuario.UsuarioEntity;
import com.utn.TallerAPI.features.usuario.UsuarioRepository;
import io.swagger.v3.oas.annotations.servers.Server;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ClienteServiceImpl implements ClienteService {


    private final ClienteRepository clienteRepository;
    private final ClienteMapper clienteMapper;
    private final UsuarioRepository usuarioRepository;


    @Override
    @Transactional
    public ClienteResponse crear(ClienteRequest clienteRequest){

        UsuarioEntity usuario = usuarioRepository.findById(clienteRequest.usuarioId())
                .orElseThrow(() -> new ResourceNotFoundException("No se encontró el usuario con ID: " + clienteRequest.usuarioId()));

        if(clienteRepository.findByUsuarioId(clienteRequest.usuarioId()).isPresent()){
            throw new BusinessException("El usuario con id: "+clienteRequest.usuarioId()+" ya tiene una cuenta de cliente");
        }

        ClienteEntity c = clienteMapper.toEntity(clienteRequest);
        c.setUsuario(usuario);

        return clienteMapper.toResponse(clienteRepository.save(c));
    }

    public ClienteResponse obtenerPorID(Integer id){

        ClienteEntity c= clienteRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("No se encontro ningun cliente con el id: "+id));
        return clienteMapper.toResponse(c);
    }

    public List<ClienteResponse> obtenerTodosClientes(){

        return clienteRepository.findAll().stream()
                .map(clienteMapper :: toResponse).collect(Collectors.toList());

    }


}
