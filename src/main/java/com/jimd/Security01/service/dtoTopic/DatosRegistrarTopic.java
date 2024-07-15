package com.jimd.Security01.service.dtoTopic;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

public record DatosRegistrarTopic(
        @NotBlank
        @Column(unique = true)
        String titulo,
        @NotBlank
        @Column(unique = true)
        String mensaje,
        @JsonIgnore
        @CreationTimestamp
        LocalDateTime fechaCreacion,
        boolean status,
        Long curso,
        Long usuario
) {

}
