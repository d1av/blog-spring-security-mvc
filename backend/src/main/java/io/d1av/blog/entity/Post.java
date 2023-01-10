package io.d1av.blog.entity;

import io.d1av.blog.payload.CommentDto;
import io.d1av.blog.payload.PostDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(
        name = "posts", uniqueConstraints = {@UniqueConstraint(columnNames = {"title"})}
)
public class Post {

    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "content", nullable = false)
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<Comment> comments = new HashSet<>();
    public Post(PostDto entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.description = entity.getDescription();
        this.content = entity.getContent();
        this.comments = mapDtoToEntity(entity.getComments());
    }

    private Set<Comment> mapDtoToEntity(Set<CommentDto> dto) {
        Set<Comment> comment = new HashSet<>();
        if (dto == null) {
            return comment;
        } else {
            return dto.stream().map(commentDto -> new Comment(commentDto)).collect(Collectors.toSet());
        }
    }

}
