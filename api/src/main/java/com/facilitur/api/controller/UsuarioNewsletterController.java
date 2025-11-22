package com.facilitur.api.controller;

import com.facilitur.api.DTO.usuario_newsletter.*;
import com.facilitur.api.models.entities.UsuarioNewsletter;
import com.facilitur.api.service.EmailService;
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

    @Autowired
    private EmailService emailService;

    @PostMapping
    public ResponseEntity<?> cadastrarOuAtivarUsuarioNewsletter(@RequestBody @Valid CreateRequestDTO dados, UriComponentsBuilder uriBuilder) {

        CreateResponseDTO respostaDaRequisicao = service.cadatrarUsuarioNaNewsletter(dados);
        UsuarioNewsletter usuario = respostaDaRequisicao.usuario();


        String assunto;
        String corpo;

        if (respostaDaRequisicao.PostForCreateNewUsuarioResponseDTO()) {
            assunto = "Bem-vindo de volta à Newsletter Facilitur!";
            corpo = "Olá " + usuario.getNome() + "!" +
                    "\n\nSeu cadastro na newsletter foi reativado com sucesso!\n\n" +
                    "Agora você voltará a receber nossos avisos e eventos semanais.\n\n" +
                    "Seja bem-vindo novamente!\nEquipe Facilitur";
        } else {
            assunto = "Bem-vindo à Newsletter Facilitur!";
            corpo = "Olá " + usuario.getNome() + "!" + "!\n\nSeu cadastro na nossa newsletter foi realizado com sucesso!\n\n" +
                    "A partir de agora você receberá semanalmente os eventos da Facilitur.\n\n" +
                    "Obrigado por se juntar a nós!\nEquipe Facilitur";
        }

        emailService.enviarEmail(usuario.getEmail(), assunto, corpo);

        if (respostaDaRequisicao.PostForCreateNewUsuarioResponseDTO()) {
            var body = Map.<String, Object>of(
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

