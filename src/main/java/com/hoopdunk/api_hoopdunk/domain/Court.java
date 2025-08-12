package com.hoopdunk.api_hoopdunk.domain;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.Instant;
import java.util.List;

@Entity
@Table(name = "quadra")
public class Court {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome", length = 30)
    private String nome;

    @Column(name = "descricao", length = 300)
    private String descricao;

    @Column(name = "nivel", length = 25)
    private String nivelQuadra;

    @Column(name = "localizacao", length = 50)
    private String localizao;

    @Column(name = "foto")
    @Lob
    private String foto;

    @Column(name = "created_at")
    @CreationTimestamp
    private Instant createdAt;

    @OneToMany(mappedBy = "quadra")
    private List<CourtPlayers> courtPlayers;

    @OneToMany(mappedBy = "quadra")
    private List<Event> events;

    public Court() {}

    public Court(Long id, String nome, String descricao, String nivelQuadra, String localizao, String foto, Instant createdAt, List<CourtPlayers> courtPlayers) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.nivelQuadra = nivelQuadra;
        this.localizao = localizao;
        this.foto = foto;
        this.createdAt = createdAt;
        this.courtPlayers = courtPlayers;
    }

    public Long getId() {
        return id;
    }
    public String getNome() {
        return nome;
    }
    public String getDescricao() {
        return descricao;
    }
    public String getNivelQuadra() {
        return nivelQuadra;
    }
    public String getLocalizao() {
        return localizao;
    }
    public String getFoto() {
        return foto;
    }
    public Instant getCreatedAt() {
        return createdAt;
    }
    public List<CourtPlayers> getCourtPlayers() {
        return courtPlayers;
    }


    public void setId(Long id) {
        this.id = id;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public void setNivelQuadra(String nivelQuadra) {
        this.nivelQuadra = nivelQuadra;
    }
    public void setLocalizao(String localizao) {
        this.localizao = localizao;
    }
    public void setFoto(String foto) {
        this.foto = foto;
    }
    public void setCreatedAt(Instant created_at) {
        this.createdAt = created_at;
    }
    public void setCourtPlayers(List<CourtPlayers> courtPlayers) {
        this.courtPlayers = courtPlayers;
    }
}
