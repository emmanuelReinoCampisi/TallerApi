package com.utn.TallerAPI.features.usuario;

import com.utn.TallerAPI.features.cliente.ClienteEntity;
import com.utn.TallerAPI.features.mecanico.MecanicoEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "usuarios")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank @Column(unique = true)
    private String userName;

    @Email @NotBlank @Column(unique = true)
    private String email;

    @NotBlank @Column(length = 70)
    private String password;

    private String nombre;
    private String apellido;

    @Column(unique = true)
    private Long DNI;

    private String telefono;

    @Enumerated @NotNull
    private Rol rol;

    private boolean activo = true;
    @Column(name="fecha_creacion")
    private LocalDate fechaCreacion = LocalDate.now();


    @OneToOne(mappedBy = "usuario",fetch = FetchType.LAZY)
    private MecanicoEntity mecanico;

    @OneToOne(mappedBy = "usuario",fetch = FetchType.LAZY)
    private ClienteEntity clienteEntity;

    @PrePersist
    public void onCreate() {
        this.fechaCreacion = LocalDate.now();
    }

}
