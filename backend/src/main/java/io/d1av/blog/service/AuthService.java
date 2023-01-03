package io.d1av.blog.service;

import io.d1av.blog.payload.LoginDto;
import io.d1av.blog.payload.RegisterDto;

public interface AuthService {
    String login(LoginDto loginDto);

    String register(RegisterDto registerDto);
}
