package io.d1av.blog.payload;

import io.d1av.blog.entity.Comment;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class CommentDto {
    private Long id;
    @NotBlank(message = "Name should not be null or empty")
    private String name;
    @NotBlank(message = "Email should not be null or empty")
    private String email;
    @NotBlank(message = "Comment body should not be null or empty")
    @Size(min = 10, message = "Comment body must be minimun 10 characters")
    private String body;

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
