package com.facilitur.api.models.entities;

import com.facilitur.api.models.enums.CategoriaEvento;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@NoArgsConstructor

@Entity
@DiscriminatorValue("ESPORTIVO")
public class EventoEsportivo extends com.facilitur.api.models.entities.Evento {

    @Column(name = "tipo_esporte", length = 100)
    private String tipoEsporte;

    public EventoEsportivo(String nome, LocalDate dataInicio, LocalDate dataFim,
                           String local, LocalTime horario, String tipoEsporte) {
        super(null, nome, dataInicio, dataFim, local, horario, CategoriaEvento.ESPORTIVO);
        this.tipoEsporte = tipoEsporte;
    }
}
