package com.facilitur.api.repository;

import com.facilitur.api.models.entities.EventoEsportivo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EventoEsportivoRepository extends JpaRepository<EventoEsportivo, Long> {
    List<EventoEsportivo> findByCategoria(Enum categoria);
}
