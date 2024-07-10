package com.jimd.Security01.service.topic;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public record RespuestaAMostrar(
        String mensaje,
        @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
        LocalDateTime fechaCreacion
) {
}
