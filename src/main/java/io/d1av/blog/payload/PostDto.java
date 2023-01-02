package io.d1av.blog.payload;


import io.d1av.blog.entity.Comment;
import io.d1av.blog.entity.Post;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class PostDto {
    private Long id;
    @NotBlank
    @Size(min = 2, message = "Post title should have at least 2 characters")
    private String title;

    @NotBlank
    @Size(min = 10, message = "Post description should have at least 10 characters")
    private String description;
    @NotEmpty
    @Size(min = 10, message = "Post description should have at least 10 characters")
    private String content;
    private Set<CommentDto> comments;

    public PostDto() {
    }

    public PostDto(Long id, String title, String description, String content, Set<CommentDto> comments) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.content = content;
        this.comments = comments;
    }

    public PostDto(Post entity) {
        id = entity.getId();
        title = entity.getTitle();
        description = entity.getDescription();
        content = entity.getContent();
        comments = mapCommentsToDto(entity.getComments());
    }

    private Set<CommentDto> mapCommentsToDto(Set<Comment> comments) {
        if (comments == null) {
            Set<CommentDto> dto = new HashSet<>();
            return dto;
        } else {
            return comments.stream().map(CommentDto::new).collect(Collectors.toSet());
        }
    }

    public Set<CommentDto> getComments() {
        return comments;
    }

    public void setComments(Set<CommentDto> comments) {
        this.comments = comments;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
