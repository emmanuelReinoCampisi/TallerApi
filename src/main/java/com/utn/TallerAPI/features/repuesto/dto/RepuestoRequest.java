package com.utn.TallerAPI.features.repuesto.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
@NoArgsConstructor
public class RepuestoRequest {

        @NotBlank(message = "El codigo de repuesto es obligatorio")
        private String codigoRepuesto;

        @NotBlank(message = "El nombre del repuesto es obligatorio")
        private String nombreRepuesto;

        @NotNull(message = "El precio de COSTO es obligatorio")
        @Positive(message = "El precio debe ser mayor a 0")
        private BigDecimal precioCosto;

        @NotNull(message = "El precio de VENTA es obligatorio")
        @Positive(message = "El precio debe ser mayor a 0")
        private BigDecimal precioVenta;

        @NotNull(message = "El stock actual es obligatorio")
        @Min(value = 0, message = "El stock no puede ser negativo")
        private Integer stockActual;

        @NotNull(message = "El stock mínimo es obligatorio")
        @Min(value = 0, message = "El stock mínimo no puede ser negativo")
        private Integer stockMinimo;


        public String getCodigoRepuesto() {
                return codigoRepuesto;
        }

        public void setCodigoRepuesto(String codigoRepuesto) {
                this.codigoRepuesto = codigoRepuesto;
        }

        public String getNombreRepuesto() {
                return nombreRepuesto;
        }

        public void setNombreRepuesto(String nombreRepuesto) {
                this.nombreRepuesto = nombreRepuesto;
        }

        public BigDecimal getPrecioCosto() {
                return precioCosto;
        }

        public void setPrecioCosto(BigDecimal precioCosto) {
                this.precioCosto = precioCosto;
        }

        public BigDecimal getPrecioVenta() {
                return precioVenta;
        }

        public void setPrecioVenta(BigDecimal precioVenta) {
                this.precioVenta = precioVenta;
        }

        public Integer getStockActual() {
                return stockActual;
        }

        public void setStockActual(Integer stockActual) {
                this.stockActual = stockActual;
        }

        public Integer getStockMinimo() {
                return stockMinimo;
        }

        public void setStockMinimo(Integer stockMinimo) {
                this.stockMinimo = stockMinimo;
        }
}
