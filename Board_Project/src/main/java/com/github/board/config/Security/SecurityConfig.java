package com.github.board.config.Security;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;
@Configuration
@EnableWebSecurity

public class SecurityConfig {


    @Bean
    public SecurityFilterChain config(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable);
        http
                .authorizeHttpRequests(
                        authorize -> authorize
                                .requestMatchers("/api/*").permitAll()
                                .requestMatchers("/api/signup").permitAll()
                                .requestMatchers("/api/login").permitAll()
                                .requestMatchers("/api/logout").permitAll()
                                .requestMatchers("/api/comments").permitAll()

                                .anyRequest().authenticated()
                );



        return http.build();
    }
}
