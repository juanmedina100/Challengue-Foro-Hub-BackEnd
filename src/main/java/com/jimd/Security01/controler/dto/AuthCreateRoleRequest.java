package com.jimd.Security01.controler.dto;

import jakarta.validation.constraints.Size;
import org.springframework.validation.annotation.Validated;

import java.util.List;
@Validated
public record AuthCreateRoleRequest(
        @Size(max = 3,message = "error") List<String> roleListName
) {
}
