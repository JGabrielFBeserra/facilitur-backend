package com.facilitur.api.service;

import com.facilitur.api.DTO.usuario_newsletter.*;
import com.facilitur.api.entities.UsuarioNewsletter;
import com.facilitur.api.repository.UsuarioNewsletterRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioNewsletterService {

    @Autowired
    private UsuarioNewsletterRepository repository;

    @Transactional
    public CreateResponseDTO cadatrarUsuarioNaNewsletter(@Valid CreateRequestDTO dados) {
        UsuarioNewsletter usuarioNewsletter = new UsuarioNewsletter(dados);
        boolean usuarioJaExiste = false;

        Optional<UsuarioNewsletter> usuarioJaTemCadastro = repository.findByEmail(dados.email());
        if (usuarioJaTemCadastro.isPresent()) {
            UsuarioNewsletter user = usuarioJaTemCadastro.get();
            user.ativarCasoJaExistaUsuarioNaNewsletter();
            usuarioJaExiste = true;
            return new CreateResponseDTO(usuarioNewsletter, usuarioJaExiste,   "Usuário já existia e foi reativado");
        } else {
            repository.save(usuarioNewsletter);
            return new CreateResponseDTO(usuarioNewsletter, usuarioJaExiste, "Usuário cadastrado com sucesso");
        }


    }

    @Transactional
    public PatchDesativarUsuarioResponseDTO desativarUsuarioNewsletter(@Valid PatchDesativarUsuarioRequestDTO email) {
        Optional<UsuarioNewsletter> usuario = repository.findByEmail(email.email());
        if (usuario.isPresent()) {
            UsuarioNewsletter user = usuario.get();
            user.desativarUsuarioNewsletter();
            return new PatchDesativarUsuarioResponseDTO( user.getEmail(), "Usuário Desativado com Sucesso!");
        } else {
            return new PatchDesativarUsuarioResponseDTO(null, "Usuário não encontrado");

        }
    }
}



