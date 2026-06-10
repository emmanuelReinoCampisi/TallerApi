package com.utn.TallerAPI.security.controller;

import com.utn.TallerAPI.features.usuario.Rol;
import com.utn.TallerAPI.features.usuario.UsuarioEntity;
import com.utn.TallerAPI.features.usuario.UsuarioRepository;
import com.utn.TallerAPI.security.dto.JwtRequest;
import com.utn.TallerAPI.security.dto.JwtResponse;
import com.utn.TallerAPI.security.dto.RefreshTokenRequest;
import com.utn.TallerAPI.security.dto.RegisterRequest;
import com.utn.TallerAPI.security.jwt.JwtUtil;
import com.utn.TallerAPI.security.service.UserDetailsServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;
    private final UsuarioRepository usuarioRepository;
    private final UserDetailsServiceImpl userDetailsServiceImpl;

    @PostMapping("/login")
    public ResponseEntity<JwtResponse> login(@Valid @RequestBody JwtRequest request) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword())
        );

        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        UsuarioEntity usuario = usuarioRepository.findByUserName(userDetails.getUsername())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        String token = jwtUtil.generateToken(usuario);
        String refreshToken = jwtUtil.generateRefreshToken(usuario);

        return ResponseEntity.ok(JwtResponse.builder()
                .token(token)
                .refreshToken(refreshToken)
                .id(usuario.getId())
                .username(usuario.getUserName())
                .email(usuario.getEmail())
                .rol(usuario.getRol())
                .expiresIn(jwtUtil.extractExpiration(token).getTime() - System.currentTimeMillis())
                .build());
    }

    @PostMapping("/register")
    public ResponseEntity<JwtResponse> register(@Valid @RequestBody RegisterRequest request) {
        if (usuarioRepository.existsByUserName(request.getUsername())) {
            return ResponseEntity.badRequest().build();
        }
        if (usuarioRepository.existsByEmail(request.getEmail())) {
            return ResponseEntity.badRequest().build();
        }
        if (request.getDni() != null && usuarioRepository.existsByDNI(request.getDni())) {
            return ResponseEntity.badRequest().build();
        }

        UsuarioEntity usuario = UsuarioEntity.builder()
                .userName(request.getUsername())
                .password(request.getPassword())
                .email(request.getEmail())
                .nombre(request.getNombre())
                .apellido(request.getApellido())
                .DNI(request.getDni())
                .telefono(request.getTelefono())
                .rol(request.getRol() != null ? request.getRol() : Rol.CLIENTE)
                .activo(true)
                .build();

        usuario = usuarioRepository.save(usuario);

        String token = jwtUtil.generateToken(usuario);
        String refreshToken = jwtUtil.generateRefreshToken(usuario);

        return ResponseEntity.ok(JwtResponse.builder()
                .token(token)
                .refreshToken(refreshToken)
                .id(usuario.getId())
                .username(usuario.getUserName())
                .email(usuario.getEmail())
                .rol(usuario.getRol())
                .expiresIn(jwtUtil.extractExpiration(token).getTime() - System.currentTimeMillis())
                .build());
    }

    @PostMapping("/refresh")
    public ResponseEntity<JwtResponse> refreshToken(@Valid @RequestBody RefreshTokenRequest request) {
        if (!jwtUtil.validateToken(request.getRefreshToken())) {
            return ResponseEntity.status(401).build();
        }

        String username = jwtUtil.extractUsername(request.getRefreshToken());
        UsuarioEntity usuario = usuarioRepository.findByUserName(username)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        String token = jwtUtil.generateToken(usuario);
        String refreshToken = jwtUtil.generateRefreshToken(usuario);

        return ResponseEntity.ok(JwtResponse.builder()
                .token(token)
                .refreshToken(refreshToken)
                .id(usuario.getId())
                .username(usuario.getUserName())
                .email(usuario.getEmail())
                .rol(usuario.getRol())
                .expiresIn(jwtUtil.extractExpiration(token).getTime() - System.currentTimeMillis())
                .build());
    }

    @GetMapping("/me")
    public ResponseEntity<JwtResponse> getCurrentUser(Authentication authentication) {
        String username = authentication.getName();
        UsuarioEntity usuario = usuarioRepository.findByUserName(username)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        String token = jwtUtil.generateToken(usuario);
        return ResponseEntity.ok(JwtResponse.builder()
                .token(token)
                .id(usuario.getId())
                .username(usuario.getUserName())
                .email(usuario.getEmail())
                .rol(usuario.getRol())
                .expiresIn(jwtUtil.extractExpiration(token).getTime() - System.currentTimeMillis())
                .build());
    }
}