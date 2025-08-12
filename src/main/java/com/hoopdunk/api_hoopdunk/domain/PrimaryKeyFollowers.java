package com.hoopdunk.api_hoopdunk.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable //p JPA entender que isso fará parte de outra tabela como campo, não tabela (entidade)
public class PrimaryKeyFollowers implements Serializable { //Hibernate precisa serializar/dessereializar)

    @Column(name = "idSeguidor")
    private Long idSeguidor;

    @Column(name = "idSeguido")
    private Long idSeguido;

    public PrimaryKeyFollowers() {} //pro JPA funcionar corretamente

    //para testes e etc
    public PrimaryKeyFollowers(Long idSeguido, Long idSeguidor){
        this.idSeguido = idSeguido;
        this.idSeguidor = idSeguidor;
    }

    public Long getIdSeguidor() {
        return this.idSeguidor;
    }
    public Long getIdSeguido() {
        return this.idSeguido;
    }

    public void setIdSeguido(Long idSeguido) {
        this.idSeguido = idSeguido;
    }
    public void setIdSeguidor(Long idSeguidor) {
        this.idSeguidor = idSeguidor;
    }





}
