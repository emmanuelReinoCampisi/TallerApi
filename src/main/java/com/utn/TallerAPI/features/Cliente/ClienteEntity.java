package com.utn.TallerAPI.features.Cliente;

import com.utn.TallerAPI.features.Usuario.UsuarioEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="clientes")
@Getter
@Setter
@Builder
public class ClienteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated @NotBlank @NotNull
    private TipoCliente tipoCliente;

    @OneToOne @JoinColumn (name = "user_id", unique = true)
    private UsuarioEntity usuario;

    @OneToMany(mappedBy = "cliente",fetch = FetchType.LAZY)
    private List<Truno> turnos;

    @OneToMany(mappedBy = "cliente",fetch = FetchType.LAZY)
    private DeudaCliente deudaCliente;

    @OneToMany(mappedBy = "cliete",fetch = FetchType.LAZY)
    private List<Pago> pagos;
}
