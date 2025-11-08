package com.facilitur.api.service;

import com.facilitur.api.DTO.usuario_newsletter.CreateResponseDTO;
import com.facilitur.api.DTO.usuario_newsletter.DesativarViaEmailDTO;
import com.facilitur.api.DTO.usuario_newsletter.CreateDTO;
import com.facilitur.api.DTO.usuario_newsletter.PatchReativarUsuarioNewsletterResponseDTO;
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
    public CreateResponseDTO cadatrarUsuarioNaNewsletter(@Valid CreateDTO dados) {
        UsuarioNewsletter usuarioNewsletter = new UsuarioNewsletter(dados);
        boolean jaExiste = false;

        Optional<UsuarioNewsletter> usuarioJaTemCadastro = repository.findByEmail(dados.email());
        if (usuarioJaTemCadastro.isPresent()) {
            UsuarioNewsletter user = usuarioJaTemCadastro.get();
            user.ativarCasoJaExistaUsuarioNaNewsletter();
            jaExiste = true;
            return new CreateResponseDTO(usuarioNewsletter, jaExiste,   "Usuário já existia e foi reativado");
        } else {
            repository.save(usuarioNewsletter);
            return new CreateResponseDTO(usuarioNewsletter, jaExiste, "Usuário cadastrado com sucesso");
        }


    }

    @Transactional
    public PatchReativarUsuarioNewsletterResponseDTO desativarUsuarioNewsletter(@Valid DesativarViaEmailDTO email) {
        Optional<UsuarioNewsletter> usuario = repository.findByEmail(email.email());
        if (usuario.isPresent()) {
            UsuarioNewsletter user = usuario.get();
            user.desativarUsuarioNewsletter();
            return new PatchReativarUsuarioNewsletterResponseDTO(user.getEmail(), user.isAtivo());
        }
        return new PatchReativarUsuarioNewsletterResponseDTO("",false);
    }
}



