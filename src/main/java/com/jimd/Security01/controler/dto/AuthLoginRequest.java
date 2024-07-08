package com.jimd.Security01.controler.dto;

import jakarta.validation.constraints.NotBlank;

public record AuthLoginRequest(
        @NotBlank String username,
        @NotBlank String password
) {
}
