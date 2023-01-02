package io.d1av.blog.service;

import io.d1av.blog.payload.CommentDto;

public interface CommentService {
    CommentDto createComment(Long postId,CommentDto commentDto);
}
