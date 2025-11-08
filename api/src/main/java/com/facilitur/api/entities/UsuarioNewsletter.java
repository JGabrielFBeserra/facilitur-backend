package com.facilitur.api.entities;

import com.facilitur.api.DTO.usuario_newsletter.CreateDTO;
import jakarta.persistence.*;
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


    public UsuarioNewsletter(CreateDTO dados) {
        this.nome = dados.nome();
        this.email = dados.email();
        this.celular = dados.celular();
        this.ativo = true;

    }


    public void desativarUsuarioNewsletter(){
        System.out.println(this.ativo);
        this.ativo = false;
        System.out.println("desativou");
    }

    public void ativarCasoJaExistaUsuarioNaNewsletter() {
        System.out.println(this.ativo);
        this.ativo = true;
        System.out.println("ativou");
    }
}
