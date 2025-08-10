package com.hoopdunk.api_hoopdunk.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class CourtPlayersPrimaryKey implements Serializable {

    @Column(name = "idQuadra")
    private Long idQuadra;

    @Column(name = "idUsuario")
    private Long idUser;

    public CourtPlayersPrimaryKey() {}

    public CourtPlayersPrimaryKey(Long idQuadra, Long idUser) {
        this.idQuadra = idQuadra;
        this.idUser = idUser;
    }

    public Long getIdQuadra() {
        return idQuadra;
    }

    public void setIdQuadra(Long idQuadra) {
        this.idQuadra = idQuadra;
    }

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }
}
