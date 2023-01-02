package io.d1av.blog.repository;

import io.d1av.blog.entity.Comment;
import io.d1av.blog.entity.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    Page<Comment> findByPostId(Long id, Pageable pageable);
}
