package com.jimd.Security01.service.topic;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.annotations.CreationTimestamp;

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
