package com.hoopdunk.api_hoopdunk.domain;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.Instant;

@Entity
@Table(name = "usuario")
public class User {

    @Id //tenho que falar que é um id no banco, se comporte como uma PK
    @GeneratedValue(strategy = GenerationType.AUTO) //tipo o auto_increment
    private Integer id;

    private String nome;

    private String nomePerfil;

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
        return this.nomePerfil;
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
        this.nomePerfil = nomePerfil;
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

//    public User(Integer id, String nome, String nomePerfil, String email, String senha, String posicao, String nivel, String foto, Instant created_at) {
//          this.id = id;
//          this.nome = nome;
//          this.nomePerfil = nomePerfil;
//          this.email = email;
//          this.senha = senha;
//          this.posicao = posicao;
//          this.nivel = nivel;
//          this.foto = foto;
//          this.created_at = created_at;
//    }

}
