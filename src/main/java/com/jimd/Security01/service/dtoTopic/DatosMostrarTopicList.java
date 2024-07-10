package com.jimd.Security01.service.dtoTopic;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;
import java.util.List;

public record DatosMostrarTopicList(
        String titulo,
        String mensaje,
        @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
        LocalDateTime fechaCreacion,
        Boolean status,
        String curso,
        String usuario,
        List<RespuestaAMostrar> respuestaAMostrarList
) {
}
