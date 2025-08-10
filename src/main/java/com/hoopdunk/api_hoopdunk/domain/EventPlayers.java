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
    @MapsId("idUser")
    @JoinColumn(name = "idUsuario")
    private User user;

    public EventPlayers(){}
    public EventPlayers(EventPlayersPrimaryKey id, Event evento, User user) {
        this.id = id;
        this.evento = evento;
        this.user = user;
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

    public void setId(EventPlayersPrimaryKey id) {
        this.id = id;
    }
    public void setEvento(Event evento) {
        this.evento = evento;
    }
    public void setUser(User user) {
        this.user = user;
    }
}
