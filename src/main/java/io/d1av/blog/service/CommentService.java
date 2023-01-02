package io.d1av.blog.service;

import io.d1av.blog.payload.CommentDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CommentService {
    CommentDto createComment(Long postId, CommentDto commentDto);

    Page<CommentDto> getAllCommentsByPostId(Long postId, Pageable pageable);

    CommentDto getCommentById(Long postId, Long commentId);

    CommentDto updateComment(Long postId, Long commentId, CommentDto commentDto);
}
