package com.facilitur.api.models.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@DiscriminatorValue("ESPORTE")
public class EventoEsportivo extends Evento {

    private String modalidade;
    private String organizador;

}
