package com.facilitur.api.controller;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/afiliado")
public class FiliadoController {

    @PostMapping
    public ResponseEntity<> cadastrarFiliado(@RequestBody @Valid CreateRequestDTO dados) {

    }
}
