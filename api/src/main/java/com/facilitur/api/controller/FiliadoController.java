package com.facilitur.api.controller;

import com.facilitur.api.DTO.filiado.CreateRequestDTO;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.util.UriComponentsBuilder;

@Controller
@RequestMapping("/api/afiliado")
public class FiliadoController {



    @PostMapping
    public ResponseEntity<CreateRequestDTO> cadastrar(@RequestBody @Valid CreateRequestDTO dados, UriComponentsBuilder uriBuilder) {

        var medico = service.cadastrar(dados);

        var uri = uriBuilder.path("medicos/{id}").buildAndExpand(medico.getId()).toUri();

        return ResponseEntity.created(uri).body(new MedicoAllDataDTO(medico));

    }
}
