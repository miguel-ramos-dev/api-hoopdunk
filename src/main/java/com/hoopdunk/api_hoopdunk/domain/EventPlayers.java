package com.hoopdunk.api_hoopdunk.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "eventoJogadores")
public class EventPlayers {

    @EmbeddedId
    private EventPlayersPrimaryKey id;

    @ManyToOne
    @MapsId("idEvento")
    @JoinColumn(name = "idEvento")
    private Event evento;

    @ManyToOne
    @MapsId("idJogador")
    @JoinColumn(name = "idJogador")
    private User user;

    @Column(name = "tipoJogador", length = 20)
    private String tipoJogador;

    public EventPlayers(){}
    public EventPlayers(EventPlayersPrimaryKey id, Event evento, User user, String tipoJogador) {
        this.id = id;
        this.evento = evento;
        this.user = user;
        this.tipoJogador = tipoJogador;
    }


    public EventPlayersPrimaryKey getId() {
        return id;
    }
    public Event getEvento() {
        return evento;
    }
    public User getUser() {
        return user;
    }
    public String getTipoJogador() {
        return tipoJogador;
    }

    public void setId(EventPlayersPrimaryKey id) {
        this.id = id;
    }
    public void setEvento(Event evento) {
        this.evento = evento;
    }
    public void setUser(User user) {
        this.user = user;
    }
    public void setTipoJogador(String tipoJogador) {
        this.tipoJogador = tipoJogador;
    }
}
