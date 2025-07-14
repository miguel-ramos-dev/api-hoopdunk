package com.hoopdunk.api_hoopdunk.domain;

import com.hoopdunk.api_hoopdunk.dto.user.CreateUserDto;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.Instant;

@Entity
@Table(name = "usuario")

public class User {

    @Id //tenho que falar que é um id no banco, se comporte como uma PK
    @GeneratedValue(strategy = GenerationType.IDENTITY) //tipo o auto_increment
    private Integer id;

    private String nome;

    private String nome_perfil;

    private String email;

    private String senha;

    private String posicao;

    private String nivel;

    @Column(columnDefinition = "TEXT")
    private String foto;

    @CreationTimestamp
    private Instant created_at; //quando criar entidade ele ja lanca a datahora

    //metodos
    public Integer getId() {
        return this.id;
    }
    public String getNome() {
        return this.nome;
    }
    public String getNomePerfil() {
        return this.nome_perfil;
    }
    public String getEmail() {
        return this.email;
    }
    public String getSenha() {
        return this.senha;
    }
    public String getPosicao() {
        return this.posicao;
    }
    public String getNivel() {
        return this.nivel;
    }
    public String getFoto() {
        return this.foto;
    }
    public Instant getCreatedAt() {
        return this.created_at;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setNomePerfil(String nomePerfil) {
        this.nome_perfil = nomePerfil;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setSenha(String senha){
        this.senha = senha;
    }
    public void setPosicao(String posicao) {
        this.posicao = posicao;
    }
    public void setNivel(String nivel) {
        this.nivel = nivel;
    }
    public void setFoto(String foto) {
        this.foto = foto;
    }


    public User() {}

//    public User(String nome, String nomePerfil, String email, String senha) {
//          this.nome = nome;
//          this.nome_perfil = nomePerfil;
//          this.email = email;
//          this.senha = senha;
//    }

    //sobrecarregando construtor para receber a classe DTO para criar um usuario
    public User(CreateUserDto createUserDto) {
        this.nome = createUserDto.nome();
        this.nome_perfil = createUserDto.nomePerfil();
        this.email = createUserDto.email();
        this.senha = createUserDto.senha();
    }

}
