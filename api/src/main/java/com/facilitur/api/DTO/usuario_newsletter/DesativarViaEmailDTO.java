package com.facilitur.api.DTO.usuario_newsletter;

import com.facilitur.api.entities.UsuarioNewsletter;

public record DesativarViaEmailDTO(String email) {
    DesativarViaEmailDTO(UsuarioNewsletter usuarioNewsletter){
        this(usuarioNewsletter.getEmail());
    }
}


