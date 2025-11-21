package com.facilitur.api.DTO.usuario_newsletter;

import com.facilitur.api.models.entities.UsuarioNewsletter;

public record PatchDesativarUsuarioRequestDTO(String email) {
    PatchDesativarUsuarioRequestDTO(UsuarioNewsletter usuarioNewsletter){
        this(usuarioNewsletter.getEmail());
    }
}


