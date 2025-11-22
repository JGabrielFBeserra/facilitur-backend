package com.facilitur.api.models.entities;

import com.facilitur.api.models.enums.CategoriaEvento;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")

@Entity
@Table(name = "eventos")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "categoria", discriminatorType = DiscriminatorType.STRING)
public abstract class Evento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 200)
    private String nome;

    @Column(name = "data_inicio", nullable = false)
    private LocalDate dataInicio;

    @Column(name = "data_fim", nullable = false)
    private LocalDate dataFim;

    @Column(nullable = false, length = 255)
    private String local;

    @Column(nullable = false)
    private LocalTime horario;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, insertable = false, updatable = false)
    private CategoriaEvento categoria;
}
