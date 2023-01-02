package io.d1av.blog.repository;

import io.d1av.blog.entity.Comment;
import io.d1av.blog.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
