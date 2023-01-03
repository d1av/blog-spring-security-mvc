package io.d1av.blog.service;

import io.d1av.blog.payload.LoginDto;

public interface AuthService {
    String login(LoginDto loginDto);
}
