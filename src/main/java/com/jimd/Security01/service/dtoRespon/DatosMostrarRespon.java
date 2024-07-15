package com.jimd.Security01.service.dtoRespon;

import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

public record DatosMostrarRespon(
        String mensaje,
        LocalDateTime fechaCreacion
) {
}
