package com.jimd.Security01.service.dtoRespon;

import jakarta.validation.constraints.NotBlank;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

public record DatosAgregarResponse(
        @NotBlank
        String mensaje,
        @CreationTimestamp
        LocalDateTime fechaCreacion,
        boolean solucion,
        Long topic,
        Long user
) {
}
