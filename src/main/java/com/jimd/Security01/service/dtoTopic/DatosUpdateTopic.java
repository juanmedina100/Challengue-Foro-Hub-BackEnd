package com.jimd.Security01.service.dtoTopic;

public record DatosUpdateTopic(
        String titulo,
        String mensaje,
//        LocalDateTime fechaCreacion,
        boolean status,
        Long curso,
        Long usuario
) {
}
