package com.hoopdunk.api_hoopdunk.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "quadraJogadores")
public class CourtPlayers {

    @EmbeddedId
    private CourtPlayersPrimaryKey id;

    @ManyToOne
    @MapsId("idQuadra") //pega id da entidade e joga la pra outra entidade (da chave composta)
    @JoinColumn(name = "idQuadra")
    private Court quadra;

    @ManyToOne
    @MapsId("idUser")
    @JoinColumn(name = "idUsuario")
    private User user;

    @Column(name = "tipoJogador", length = 20)
    private String tipoJogador;

    public CourtPlayers() {}

    public CourtPlayers(CourtPlayersPrimaryKey id, Court quadra, User user, String tipoJogador) {
        this.id = id;
        this.quadra = quadra;
        this.user = user;
        this.tipoJogador = tipoJogador;
    }

    public CourtPlayersPrimaryKey getId() {
        return id;
    }
    public Court getQuadra() {
        return quadra;
    }
    public User getUser() {
        return user;
    }
    public String getTipoJogador() {
        return tipoJogador;
    }

    public void setId(CourtPlayersPrimaryKey id) {
        this.id = id;
    }
    public void setQuadra(Court quadra) {
        this.quadra = quadra;
    }
    public void setUser(User user) {
        this.user = user;
    }
    public void setTipoJogador(String tipoJogador) {
        this.tipoJogador = tipoJogador;
    }
}
