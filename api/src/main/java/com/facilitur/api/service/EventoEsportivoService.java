package com.facilitur.api.service;

import com.facilitur.api.models.entities.EventoEsportivo;
import com.facilitur.api.repository.EventoEsportivoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EventoEsportivoService {

    private final EventoEsportivoRepository repository;

    public EventoEsportivo criar(EventoEsportivo evento) {
        return repository.save(evento);
    }

    public List<EventoEsportivo> listarTodos() {
        return repository.findAll();
    }

    public EventoEsportivo buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Evento esportivo não encontrado"));
    }

    public EventoEsportivo atualizar(Long id, EventoEsportivo dados) {
        EventoEsportivo existente = buscarPorId(id);

        existente.setNome(dados.getNome());
        existente.setDescricaoResumida(dados.getDescricaoResumida());
        existente.setDescricaoDetalhada(dados.getDescricaoDetalhada());
        existente.setDataInicio(dados.getDataInicio());
        existente.setDataFim(dados.getDataFim());
        existente.setLocal(dados.getLocal());
        existente.setLinkMapa(dados.getLinkMapa());
        existente.setStatus(dados.getStatus());
        existente.setLinkCompra(dados.getLinkCompra());

        existente.setModalidade(dados.getModalidade());
        existente.setOrganizador(dados.getOrganizador());

        return repository.save(existente);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}
