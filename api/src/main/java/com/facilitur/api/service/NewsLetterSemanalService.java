package com.facilitur.api.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.format.DateTimeFormatter;
import java.util.List;

import com.facilitur.api.models.entities.Evento;
import com.facilitur.api.models.entities.UsuarioNewsletter;
import com.facilitur.api.repository.UsuarioNewsletterRepository;
import com.facilitur.api.service.EventoService;
import com.facilitur.api.service.EmailService;

@Service
public class NewsLetterSemanalService {
    @Autowired
    private EventoService eventoService;

    @Autowired
    private UsuarioNewsletterRepository usuarioRepository;

    @Autowired
    private EmailService emailService;

    public void enviarNewsletterSemanal() {

        List<Evento> eventos = eventoService.buscarEventosDaSemana();

        if (eventos.isEmpty()) {
            System.out.println("Nenhum evento para enviar esta semana.");
            return;
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        StringBuilder corpo = new StringBuilder();
        corpo.append("Olá!\n\n");
        corpo.append("Confira os eventos que acontecerão nesta semana:\n\n");

        for (Evento e : eventos) {
            corpo.append("• ").append(e.getNome()).append("\n")
                    .append("  Categoria: ").append(e.getCategoria()).append("\n")
                    .append("  📅 De ").append(e.getDataInicio().format(formatter))
                    .append(" até ").append(e.getDataFim().format(formatter)).append("\n")
                    .append("  📍 Local: ").append(e.getLocal()).append("\n")
                    .append("  🕒 Horário: ").append(e.getHorario()).append("\n\n");
        }

        corpo.append("\nEsperamos ter você em nossos eventos!\nEquipe Facilitur");

        List<UsuarioNewsletter> usuarios = usuarioRepository.findByAtivoTrue();

        for (UsuarioNewsletter usr : usuarios) {
            emailService.enviarEmail(
                    usr.getEmail(),
                    "Eventos da Semana - Facilitur",
                    corpo.toString()
            );
        }

        System.out.println("Newsletter semanal enviada!");
    }
}

