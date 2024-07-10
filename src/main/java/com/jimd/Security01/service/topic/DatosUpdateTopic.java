package com.jimd.Security01.service.topic;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

public record DatosUpdateTopic(
        String titulo,
        String mensaje,
//        LocalDateTime fechaCreacion,
        boolean status,
        Long curso,
        Long usuario
) {
}
