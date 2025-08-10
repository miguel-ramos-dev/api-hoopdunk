package com.hoopdunk.api_hoopdunk.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class EventPlayersPrimaryKey implements Serializable {

    @Column(name = "idEvento", nullable = false)
    private Long idEvento;

    @Column(name = "idUsuario", nullable = false)
    private Long idUser;

    public EventPlayersPrimaryKey(){}

    public EventPlayersPrimaryKey(Long idEvento, Long idUser) {
        this.idEvento = idEvento;
        this.idUser = idUser;
    }

    public Long getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(Long idEvento) {
        this.idEvento = idEvento;
    }

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }
}
