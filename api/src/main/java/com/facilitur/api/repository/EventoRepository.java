package com.facilitur.api.repository;

import com.facilitur.api.models.entities.Evento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface EventoRepository extends JpaRepository<Evento, Long> {

    List<Evento> findByDataInicioBetween(LocalDate inicio, LocalDate fim);
}
