package com.hoopdunk.api_hoopdunk.domain;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.Instant;

@Entity
@Table(name = "seguidores")
public class Followers {

    @EmbeddedId
    private PrimaryKeyFollowers id;

    @ManyToOne
    @MapsId("idSeguidor") //pega id da entidade e joga la pra outra entidade (da chave composta)
    @JoinColumn(name = "idSeguidor")
    private User seguidor;

    @ManyToOne
    @MapsId("idSeguido")
    @JoinColumn(name = "idSeguido")
    private User seguido;

    @CreationTimestamp
    @Column(name = "dtHora")
    private Instant dtHora;


    public Followers() {}

    public Followers(PrimaryKeyFollowers id, User seguidor, User seguido, Instant dtHora) {
        this.id = id;
        this.seguidor = seguidor;
        this.seguido = seguido;
        this.dtHora = dtHora;
    }

    public PrimaryKeyFollowers getId() {
        return id;
    }

    public User getSeguidor() {
        return seguidor;
    }

    public User getSeguido() {
        return seguido;
    }

    public Instant getDtHora() {
        return dtHora;
    }

    public void setId(PrimaryKeyFollowers id) {

        this.id = id;
    }

    public void setSeguidor(User seguidor) {
        this.seguidor = seguidor;
    }

    public void setSeguido(User seguido) {
        this.seguido = seguido;
    }

    public void setDtHora(Instant dtHora) {
        this.dtHora = dtHora;
    }
}
