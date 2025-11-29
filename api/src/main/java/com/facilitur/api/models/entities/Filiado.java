package com.facilitur.api.models.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name= "filiados")
@Entity( name = "Filiado")
public class Filiado{
    private String razaoSocial;
    private String cnpj;
    private String endereco;
    private String email;
    private String telefone;

}
