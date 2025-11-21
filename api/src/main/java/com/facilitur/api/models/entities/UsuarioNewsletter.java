package com.facilitur.api.models.entities;

import com.facilitur.api.DTO.usuario_newsletter.CreateRequestDTO;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity(name="usuariosNewsletter")
@Table(name="usuarios_newsletter")
public class UsuarioNewsletter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nome;
    private String email;
    private String celular;
    private boolean ativo = true;


    public UsuarioNewsletter(@Valid CreateRequestDTO dados) {
        this.nome = dados.nome();
        this.email = dados.email();
        this.celular = dados.celular();
        this.ativo = true;

    }

    public void desativarUsuarioNewsletter(){
        System.out.println(this.ativo);
        this.ativo = false;
    }

    public void ativarCasoJaExistaUsuarioNaNewsletter() {
        System.out.println(this.ativo);
        this.ativo = true;
    }
}
