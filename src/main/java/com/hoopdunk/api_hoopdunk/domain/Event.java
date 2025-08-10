package com.hoopdunk.api_hoopdunk.domain;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "eventos")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome", length = 25 , nullable = false)
    private String nome;

    @Column(name = "modalidade", length = 45, nullable = false)
    private String modalidade;


    @Column(name = "dtHoraComeco", nullable = false)
    private LocalDateTime dthoraComeco;

    @Column(name = "dtHoraEncerramento", nullable = false)
    private LocalDateTime dthoraEncerramento;

    @Column(name = "nivelJogo", nullable = false)
    private String nivelJogo;

    @Column(name = "observacao", nullable = false)
    private String observacao;

    @Column(name = "created_at")
    @CreationTimestamp
    private Instant createdAt;

    @ManyToOne
    @JoinColumn(name = "idQuadra")
    private Court quadra;

    @OneToMany
    private List<EventPlayers> eventPlayers;

    private Event() {}
    public Event(Long id, String nome, String modalidade, LocalDateTime dthoraComeco, LocalDateTime dthoraEncerramento, String nivelJogo, String observacao, Instant createdAt, Court quadra, List<EventPlayers> eventPlayers) {
        this.id = id;
        this.nome = nome;
        this.modalidade = modalidade;
        this.dthoraComeco = dthoraComeco;
        this.dthoraEncerramento = dthoraEncerramento;
        this.nivelJogo = nivelJogo;
        this.observacao = observacao;
        this.createdAt = createdAt;
        this.quadra = quadra;
        this.eventPlayers = eventPlayers;
    }

    public Long getId() {
        return id;
    }
    public String getNome() {
        return nome;
    }
    public String getModalidade() {
        return modalidade;
    }
    public LocalDateTime getDthoraComeco() {
        return dthoraComeco;
    }
    public LocalDateTime getDthoraEncerramento() {
        return dthoraEncerramento;
    }
    public String getNivelJogo() {
        return nivelJogo;
    }
    public String getObservacao() {
        return observacao;
    }
    public Instant getCreatedAt() {
        return createdAt;
    }
    public Court getQuadra() {
        return quadra;
    }
    public List<EventPlayers> getEventPlayers() {
        return eventPlayers;
    }


    public void setId(Long id) {
        this.id = id;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setModalidade(String modalidade) {
        this.modalidade = modalidade;
    }
    public void setDthoraComeco(LocalDateTime dthoraComeco) {
        this.dthoraComeco = dthoraComeco;
    }
    public void setDthoraEncerramento(LocalDateTime dthoraEncerramento) {
        this.dthoraEncerramento = dthoraEncerramento;
    }
    public void setNivelJogo(String nivelJogo) {
        this.nivelJogo = nivelJogo;
    }
    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }
    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }
    public void setQuadra(Court quadra) {
        this.quadra = quadra;
    }
    public void setEventPlayers(List<EventPlayers> eventPlayers) {
        this.eventPlayers = eventPlayers;
    }
}
