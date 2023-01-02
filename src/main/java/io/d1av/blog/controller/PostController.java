package io.d1av.blog.controller;

import io.d1av.blog.entity.Post;
import io.d1av.blog.payload.PostDto;
import io.d1av.blog.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/posts")
public class PostController {

    @Autowired
    private PostService service;

    @PostMapping
    public ResponseEntity<PostDto> createNewPost(@RequestBody PostDto postDto) {
        return new ResponseEntity<>(service.createPost(postDto), HttpStatus.CREATED);
    }
}
