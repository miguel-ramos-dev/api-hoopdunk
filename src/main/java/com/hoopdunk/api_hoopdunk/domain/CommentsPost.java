package com.hoopdunk.api_hoopdunk.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "comentariosPost")
public class CommentsPost {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "idComentador")
    private User idComentador;

    @ManyToOne
    @JoinColumn(name = "idPost")
    private Post idPost;

    @Column(name = "descricao", length = 45, nullable = false)
    private String descricao;


}
