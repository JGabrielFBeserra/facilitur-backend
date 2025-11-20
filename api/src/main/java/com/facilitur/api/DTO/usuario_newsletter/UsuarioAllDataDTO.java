package com.facilitur.api.DTO.usuario_newsletter;

import com.facilitur.api.entities.UsuarioNewsletter;

public record UsuarioAllDataDTO(
                         String nome,
                         String email,
                         String celular,
                         boolean ativo
){
    public UsuarioAllDataDTO(UsuarioNewsletter usuarioNewsletter) {
        this(usuarioNewsletter.getNome(),usuarioNewsletter.getEmail(),usuarioNewsletter.getCelular(), usuarioNewsletter.isAtivo());
    }
}
