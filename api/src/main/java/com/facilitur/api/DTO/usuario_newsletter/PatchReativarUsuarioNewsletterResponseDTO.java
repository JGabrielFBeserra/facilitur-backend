package com.facilitur.api.DTO.usuario_newsletter;

import com.facilitur.api.entities.UsuarioNewsletter;

public record PatchReativarUsuarioNewsletterResponseDTO(String email, boolean ativo) {
    PatchReativarUsuarioNewsletterResponseDTO(UsuarioNewsletter usuario){
        this( usuario.getEmail(), usuario.isAtivo());
    }
}
