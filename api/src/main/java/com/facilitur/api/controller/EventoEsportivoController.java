package com.facilitur.api.controller;

import com.facilitur.api.models.entities.EventoEsportivo;
import com.facilitur.api.service.EventoEsportivoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/eventos/esportivos")
@RequiredArgsConstructor
public class EventoEsportivoController {

    private final EventoEsportivoService service;

    @PostMapping
    public ResponseEntity<EventoEsportivo> criar(@RequestBody EventoEsportivo evento) {
        return ResponseEntity.ok(service.criar(evento));
    }

    @GetMapping
    public ResponseEntity<List<EventoEsportivo>> listarTodos() {
        return ResponseEntity.ok(service.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EventoEsportivo> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EventoEsportivo> atualizar(
            @PathVariable Long id,
            @RequestBody EventoEsportivo evento
    ) {
        return ResponseEntity.ok(service.atualizar(id, evento));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
