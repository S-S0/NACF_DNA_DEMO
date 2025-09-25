package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        // 단방향 해시 SHA-256 적용 (보안권고가이드) !! 솔트는 기본 적용된 상태
        return Pbkdf2PasswordEncoder.defaultsForSpringSecurity_v5_8();
    }
    // 인메모리 사용
    @Bean
    public UserDetailsService userDetailsService(PasswordEncoder passwordEncoder) {
        UserDetails user = User.builder()
                .username("user")
                .password(passwordEncoder.encode("1234"))
                .roles("USER")
                .build();

        UserDetails admin = User.builder()
                .username("admin")
                .password(passwordEncoder.encode("1234"))
                .roles("ADMIN")
                .build();

        return new InMemoryUserDetailsManager(user, admin);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(
                                "/login"
                                , "/css/**"
                                , "/js/**"
                                , "/img/**"
                                , "/api/**"
                                , "/ask"
                                , "/context"
                        )
                        .permitAll() // 로그인, 정적리소스 허용
                        .anyRequest().authenticated()
                )
                .formLogin(form -> form
                        .loginPage("/login") // 로그인 페이지
                        .defaultSuccessUrl("/home", true)
                        .permitAll()
                )
                .sessionManagement(s -> s
                        .maximumSessions(1) // 동시접속 몇개까지 허용할지 -> 한개
                        .maxSessionsPreventsLogin(false)
                )
                .logout(logout -> logout
                        .logoutRequestMatcher(new AntPathRequestMatcher("/logout", "GET"))
                        .logoutSuccessUrl("/login?logout")
                        .permitAll()
                );

        return http.build();
    }
}
