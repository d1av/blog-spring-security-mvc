package io.d1av.blog.controller;

import io.d1av.blog.entity.Post;
import io.d1av.blog.payload.PostDto;
import io.d1av.blog.service.PostService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/posts")
public class PostController {

    @Autowired
    private PostService service;

    @GetMapping
    public ResponseEntity<Page<PostDto>> getAllPosts(Pageable pageable) {
        return new ResponseEntity<>(service.getAll(pageable), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<PostDto> getOnePostById(@PathVariable Long id) {
        return new ResponseEntity<>(service.getOnePostById(id), HttpStatus.OK);
    }

   // @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ResponseEntity<PostDto> createNewPost(@Valid @RequestBody PostDto postDto) {
        return new ResponseEntity<>(service.createPost(postDto), HttpStatus.CREATED);
    }

  //  @PreAuthorize("hasRole('ADMIN')")
    @PutMapping(value = "/{id}")
    public ResponseEntity<PostDto> updateOnePost(@PathVariable Long id, @Valid @RequestBody PostDto postDto) {
        return new ResponseEntity<>(service.updateOneById(id, postDto), HttpStatus.OK);
    }

  //  @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> deletePost(@PathVariable Long id) {
        service.deleteOneById(id);
        return new ResponseEntity<>("Post deleted successfully", HttpStatus.OK);
    }
}
