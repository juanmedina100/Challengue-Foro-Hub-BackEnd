package com.jimd.Security01.controler.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import org.springframework.validation.annotation.Validated;

public record AuthCreateUser(
        @NotBlank String username,
        @NotBlank String password,
        @Valid AuthCreateRoleRequest roleRequest
        ) {
}
