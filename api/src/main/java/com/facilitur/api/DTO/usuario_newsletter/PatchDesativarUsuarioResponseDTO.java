package com.facilitur.api.DTO.usuario_newsletter;

import com.facilitur.api.entities.UsuarioNewsletter;

public record PatchDesativarUsuarioResponseDTO(String email, String mensagem) {
}
