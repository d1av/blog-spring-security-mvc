package io.d1av.blog.service;

import io.d1av.blog.entity.Post;
import io.d1av.blog.payload.PostDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PostService {
    PostDto createPost(PostDto postDto);

    Page<PostDto> getAll(Pageable pageable);
}
