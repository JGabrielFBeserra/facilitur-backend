package com.facilitur.api.service;

import com.facilitur.api.models.entities.Evento;
import com.facilitur.api.repository.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;


@Service
public class EventoService {

    @Autowired
    private EventoRepository eventoRepository;

    public List<Evento> buscarEventosDaSemana() {

        LocalDate hoje = LocalDate.now();

        LocalDate segunda = hoje.with(java.time.DayOfWeek.MONDAY);

        LocalDate domingo = segunda.plusDays(6);

        return eventoRepository.findByDataInicioBetween(segunda, domingo);
    }
}

