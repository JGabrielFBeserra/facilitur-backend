package com.facilitur.api.models.entities;

import com.facilitur.api.models.enums.CategoriaEvento;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
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
    private String nome;
    @Column(name = "descricao_resumida")
    private String descricaoResumida;
    @Column(name = "descricao_detalhada")
    private String descricaoDetalhada;
    @Column(name = "data_inicio")
    private LocalDateTime dataInicio;
    @Column(name = "data_fim")
    private LocalDateTime dataFim;
    private String local;
    @Column(name = "link_mapa")
    private String linkMapa;
    private Boolean status;
    @Column(name = "link_compra")
    private String linkCompra;

}
