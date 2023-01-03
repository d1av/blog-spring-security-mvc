package io.d1av.blog.payload;

import io.d1av.blog.entity.Comment;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;


public class CommentDto {
    private long id;
    // name should not be null or empty
    @NotEmpty(message = "Name should not be null or empty")
    private String name;

    // email should not be null or empty
    // email field validation
    @NotEmpty(message = "Email should not be null or empty")
    @Email
    private String email;

    // comment body should not be bull or empty
    // Comment body must be minimum 10 characters
    @NotEmpty
    @Size(min = 10, message = "Comment body must be minimum 10 characters")
    private String body;

    public CommentDto() {
    }

    public CommentDto(long id, String name, String email, String body) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.body = body;
    }

    public CommentDto(Comment entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.email = entity.getEmail();
        this.body = entity.getBody();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
