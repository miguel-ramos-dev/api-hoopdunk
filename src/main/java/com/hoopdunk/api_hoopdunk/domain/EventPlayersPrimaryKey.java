package com.hoopdunk.api_hoopdunk.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class EventPlayersPrimaryKey implements Serializable {

    @Column(name = "idEvento", nullable = false)
    private Long idEvento;

    @Column(name = "idJogador", nullable = false)
    private Long idJogador;

    public EventPlayersPrimaryKey(){}

    public EventPlayersPrimaryKey(Long idEvento, Long idJogador) {
        this.idEvento = idEvento;
        this.idJogador = idJogador;
    }

    public Long getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(Long idEvento) {
        this.idEvento = idEvento;
    }

    public Long getidJogador() {
        return idJogador;
    }

    public void setidJogador(Long idJogador) {
        this.idJogador = idJogador;
    }
}
