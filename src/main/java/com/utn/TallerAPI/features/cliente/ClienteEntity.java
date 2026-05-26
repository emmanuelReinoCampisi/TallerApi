package com.utn.TallerAPI.features.cliente;

import com.utn.TallerAPI.features.finanzas.deuda.DeudaEntity;
import com.utn.TallerAPI.features.finanzas.pago.PagoEntity;
import com.utn.TallerAPI.features.turno.TurnoEntity;
import com.utn.TallerAPI.features.usuario.UsuarioEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

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
    private List<TurnoEntity> turnos;

    @OneToMany(mappedBy = "cliente",fetch = FetchType.LAZY)
    private List<DeudaEntity> deudaCliente;

    @OneToMany(mappedBy = "cliete",fetch = FetchType.LAZY)
    private List<PagoEntity> pagos;
}
