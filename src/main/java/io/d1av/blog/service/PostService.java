package io.d1av.blog.service;

import io.d1av.blog.entity.Post;
import io.d1av.blog.payload.PostDto;

public interface PostService {
    PostDto createPost(PostDto postDto);
}
