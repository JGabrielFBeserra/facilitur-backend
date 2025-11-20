package com.facilitur.api.DTO.usuario_newsletter;

import com.facilitur.api.entities.UsuarioNewsletter;

public record PatchDesativarUsuarioRequestDTO(String email) {
    PatchDesativarUsuarioRequestDTO(UsuarioNewsletter usuarioNewsletter){
        this(usuarioNewsletter.getEmail());
    }
}


