package com.facilitur.api.DTO.usuario_newsletter;

import com.facilitur.api.entities.UsuarioNewsletter;

public record AllDataDTO(
                         String nome,
                         String email,
                         String celular,
                         boolean ativo
){
    public AllDataDTO(UsuarioNewsletter usuarioNewsletter) {
        this(usuarioNewsletter.getNome(),usuarioNewsletter.getEmail(),usuarioNewsletter.getCelular(), usuarioNewsletter.isAtivo());
    }
}
