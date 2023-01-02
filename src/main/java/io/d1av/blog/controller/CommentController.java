package io.d1av.blog.controller;

import io.d1av.blog.payload.CommentDto;
import io.d1av.blog.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/")
public class CommentController {

    private CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping("/posts/{postId}/comments")
    public ResponseEntity<CommentDto> createComment(@PathVariable Long postId,
                                                    @RequestBody CommentDto commentDto) {
        return new ResponseEntity<>(commentService.createComment(postId, commentDto),
                HttpStatus.CREATED);
    }

    @GetMapping("/posts/{postId}/comments")
    public ResponseEntity<Page<CommentDto>> getAllCommentsByPostId(@PathVariable Long postId,
                                                                   Pageable pageable) {
        return new ResponseEntity<>(commentService.getAllCommentsByPostId(postId, pageable),
                HttpStatus.OK);
    }

    @GetMapping("/posts/{postId}/comments/{commentId}")
    public ResponseEntity<CommentDto> getAllCommentsByPostId(@PathVariable Long postId,
                                                             @PathVariable Long commentId) {
        return new ResponseEntity<>(commentService.getCommentById(postId, commentId),
                HttpStatus.OK);
    }

    @PutMapping("/posts/{postId}/comments/{commentId}")
    public ResponseEntity<CommentDto> getAllCommentsByPostId(@PathVariable Long postId,
                                                             @PathVariable Long commentId,
                                                             @RequestBody CommentDto commentDto) {
        return new ResponseEntity<>(commentService.updateComment(postId, commentId, commentDto),
                HttpStatus.OK);
    }


}
