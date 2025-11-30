package com.facilitur.api.models.entities;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name= "filiados")
@Entity( name = "Filiado")
@EqualsAndHashCode(of = "id")
public class Filiado{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String razaoSocial;
    private String cnpj;
    private String senha;
    private String endereco;
    private String email;
    private String telefone;
    private boolean status;

}
