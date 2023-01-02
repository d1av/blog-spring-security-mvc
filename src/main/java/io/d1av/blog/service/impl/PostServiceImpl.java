package io.d1av.blog.service.impl;

import io.d1av.blog.entity.Post;
import io.d1av.blog.payload.PostDto;
import io.d1av.blog.repository.PostRepository;
import io.d1av.blog.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository repository;

    @Override
    public PostDto createPost(PostDto postDto) {
        Post post = new Post();
        post.setTitle(postDto.getTitle());
        post.setDescription(postDto.getDescription());
        post.setContent(postDto.getContent());
        return new PostDto(repository.save(post));
    }
}
