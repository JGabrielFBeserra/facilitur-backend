package com.facilitur.api.DTO.usuario_newsletter;

import com.facilitur.api.entities.UsuarioNewsletter;

public record CreateResponseDTO (UsuarioNewsletter usuario, boolean jaExiste, String mensagem){

}
