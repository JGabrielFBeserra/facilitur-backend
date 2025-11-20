package com.facilitur.api.controller;

import com.facilitur.api.DTO.usuario_newsletter.*;
import com.facilitur.api.entities.UsuarioNewsletter;
import com.facilitur.api.service.UsuarioNewsletterService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Map;

@RestController
@RequestMapping("api/newsletter")
public class UsuarioNewsletterController {

    @Autowired
    UsuarioNewsletterService service;


    @PostMapping
    public ResponseEntity<?> cadastrarOuAtivarUsuarioNewsletter(@RequestBody @Valid CreateRequestDTO dados, UriComponentsBuilder uriBuilder) {

        CreateResponseDTO respostaDaRequisicao = service.cadatrarUsuarioNaNewsletter(dados);
        UsuarioNewsletter usuario = respostaDaRequisicao.usuario();

        if (respostaDaRequisicao.PostForCreateNewUsuarioResponseDTO()) {
            var body = Map.<String, Object>of (
                    "usuario", new PatchReativarUsuarioDTO(usuario.getEmail(), usuario.isAtivo()),
                    "mensagem", respostaDaRequisicao.mensagem()
            );
            return ResponseEntity.ok(body);
        } else {
            var uri = uriBuilder.path("newsletter/{id}").buildAndExpand(usuario.getId()).toUri();
            var body = Map.<String, Object>of(
                    "usuario", new UsuarioAllDataDTO(usuario),
                    "mensagem", respostaDaRequisicao.mensagem()
            );
            return ResponseEntity.created(uri).body(body);
        }

    }

    @PatchMapping
    public ResponseEntity<PatchDesativarUsuarioResponseDTO> desativarUsuarioNewsLetter(@RequestBody @Valid PatchDesativarUsuarioRequestDTO email){
        var resposta = service.desativarUsuarioNewsletter(email);
        if (resposta.email() == null) {
            return ResponseEntity.status(404).body(resposta);
        }
        return ResponseEntity.ok(resposta);
    }



}

