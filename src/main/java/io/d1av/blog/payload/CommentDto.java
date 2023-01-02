package io.d1av.blog.payload;

import io.d1av.blog.entity.Comment;
import io.d1av.blog.entity.Post;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class CommentDto {
    private Long id;
    private String body;
    private String email;
    private String name;

    public CommentDto() {
    }

    public CommentDto(Long id, String body, String email, String name) {
        this.id = id;
        this.body = body;
        this.email = email;
        this.name = name;
    }

    public CommentDto(Comment entity) {
        id = entity.getId();
        body = entity.getBody();
        email = entity.getEmail();
        name = entity.getName();
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

}
