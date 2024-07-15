package com.jimd.Security01.service.dtoTopic;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jimd.Security01.service.dtoRespon.DatosMostrarRespon;

import java.time.LocalDateTime;
import java.util.List;

public record DatosMostrarUnTopic(
        String titulo,
        String mensaje,
        @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
        LocalDateTime fechaCreacion,
        Boolean status,
        String curso,
        String usuario,
        List<DatosMostrarRespon> respuestaAMostrarList
) {
}
