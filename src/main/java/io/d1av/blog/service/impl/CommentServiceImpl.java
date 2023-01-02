package io.d1av.blog.service.impl;

import io.d1av.blog.entity.Comment;
import io.d1av.blog.entity.Post;
import io.d1av.blog.exception.ResourceNotFoundException;
import io.d1av.blog.payload.CommentDto;
import io.d1av.blog.repository.CommentRepository;
import io.d1av.blog.repository.PostRepository;
import io.d1av.blog.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private PostRepository postRepository;

    @Override
    public CommentDto createComment(Long postId, CommentDto commentDto) {
        Post foundedFost = postRepository.findById(postId)
                .orElseThrow(() -> new ResourceNotFoundException("Post", "id", postId));
        Comment comment = new Comment(
                null,
                commentDto.getBody(),
                commentDto.getEmail(),
                commentDto.getName(),
                foundedFost
        );
        return new CommentDto(commentRepository.save(comment));
    }
}
