package io.d1av.blog.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeHttpRequests(auth -> auth.anyRequest().authenticated()
                ).httpBasic(Customizer.withDefaults());

        return http.build();
    }


    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails ramesh = User.builder()
                .username("ramesh")
                .password("ramesh")
                .roles("ADMIN")
                .build();

        UserDetails admin = User.builder()
                .username("admin")
                .password("admin")
                .roles("ADMIN")
                .build();

        return new InMemoryUserDetailsManager(ramesh, admin);
    }
}
