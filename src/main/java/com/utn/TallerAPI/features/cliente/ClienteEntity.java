package com.utn.TallerAPI.features.cliente;

import com.utn.TallerAPI.features.finanzas.deuda.DeudaEntity;
import com.utn.TallerAPI.features.finanzas.pago.PagoEntity;
import com.utn.TallerAPI.features.turno.TurnoEntity;
import com.utn.TallerAPI.features.usuario.UsuarioEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "clientes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClienteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @NotNull
    @Column(nullable = false)
    private TipoCliente tipoCliente;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", unique = true)
    private UsuarioEntity usuario;

    @OneToMany(mappedBy = "cliente", fetch = FetchType.LAZY)
    private List<TurnoEntity> turnos;

    @OneToMany(mappedBy = "cliente", fetch = FetchType.LAZY)
    private List<DeudaEntity> deudaCliente;

    @OneToMany(mappedBy = "cliente", fetch = FetchType.LAZY)
    private List<PagoEntity> pagos;
}