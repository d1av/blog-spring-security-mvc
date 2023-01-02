package io.d1av.blog.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "comment")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String body;
    private String email;
    private String name;
    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post postId;

    public Comment() {
    }

    public Comment(Long id, String body, String email, String name, Post postId) {
        this.id = id;
        this.body = body;
        this.email = email;
        this.name = name;
        this.postId = postId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Post getPost() {
        return postId;
    }

    public void setPost(Post postId) {
        this.postId = postId;
    }
}
