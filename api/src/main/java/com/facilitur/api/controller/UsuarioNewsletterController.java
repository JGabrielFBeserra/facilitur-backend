package com.facilitur.api.controller;

import com.facilitur.api.DTO.usuario_newsletter.*;
import com.facilitur.api.entities.UsuarioNewsletter;
import com.facilitur.api.service.UsuarioNewsletterService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("api/newsletter")
public class UsuarioNewsletterController {

    @Autowired
    UsuarioNewsletterService service;


    @PutMapping
    public ResponseEntity<?> cadastrarOuAtivarUsuarioNewsletter(@RequestBody @Valid CreateDTO dados, UriComponentsBuilder uriBuilder) {

        CreateResponseDTO resp = service.cadatrarUsuarioNaNewsletter(dados);
        UsuarioNewsletter usuario = resp.usuario();

        if (resp.jaExiste()) {
            return ResponseEntity.ok(new PatchReativarUsuarioNewsletterResponseDTO(usuario.getEmail(), usuario.isAtivo()));
        } else {
            var uri = uriBuilder.path("newsletter/{id}").buildAndExpand(usuario.getId()).toUri();
            return ResponseEntity.created(uri).body(new AllDataDTO(usuario));

        }




    }

    @PatchMapping
    public ResponseEntity<PatchReativarUsuarioNewsletterResponseDTO> desativarUsuarioNewsLetter(@RequestBody @Valid DesativarViaEmailDTO email){
        System.out.println("controller");
        var usuario = service.desativarUsuarioNewsletter(email);

        return ResponseEntity.ok(usuario);

    }



}

