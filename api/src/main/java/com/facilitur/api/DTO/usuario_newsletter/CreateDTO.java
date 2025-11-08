package com.facilitur.api.DTO.usuario_newsletter;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CreateDTO(
        @NotBlank
        @Size(min = 3, max = 255)
        String nome,

        @NotBlank
        @Email
        String email,

        String celular) {}
