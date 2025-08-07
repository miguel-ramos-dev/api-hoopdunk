package com.hoopdunk.api_hoopdunk.domain;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.Instant;
import java.util.List;

@Entity
@Table(name = "post")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Lob
    @Column(name = "descricao")
    private String descricao;

    @Lob
    @Column(name = "imgPost")
    private String imgPost;

    @CreationTimestamp
    @Column(name = "dtPost")
    private Instant dtPost;

    //relação com o user
    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    @OneToMany(mappedBy = "idPost")
    private List<CommentsPost> commentsPost;


    public Post() {}

    public Post(Long id, String descricao, String imgPost, Instant dtPost, User user) {
        this.id = id;
        this.descricao = descricao;
        this.imgPost = imgPost;
        this.dtPost = dtPost;
        this.user = user;
    }

    public Long getId() {
        return id;
    }
    public String getDescricao() {
        return descricao;
    }
    public String getImgPost() {
        return imgPost;
    }
    public Instant getDtPost() {
        return dtPost;
    }


    public User getUser() {
        return user;
    }
    public List<CommentsPost> getCommentsPost() {
        return commentsPost;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public void setImgPost(String imgPost) {
        this.imgPost = imgPost;
    }
    public void setDtPost(Instant dtPost) {
        this.dtPost = dtPost;
    }
    public void setUser(User user) {
        this.user = user;
    }
    public void setCommentsPost(List<CommentsPost> commentsPost) {
        this.commentsPost = commentsPost;
    }
}
