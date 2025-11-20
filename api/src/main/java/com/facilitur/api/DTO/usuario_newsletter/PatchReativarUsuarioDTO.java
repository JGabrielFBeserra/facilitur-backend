package com.facilitur.api.DTO.usuario_newsletter;

import com.facilitur.api.entities.UsuarioNewsletter;

public record PatchReativarUsuarioDTO(String email, boolean ativo) {
    PatchReativarUsuarioDTO(UsuarioNewsletter usuario){
        this(usuario.getEmail(), usuario.isAtivo());
    }
}
