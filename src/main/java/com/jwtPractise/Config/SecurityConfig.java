package com.jwtPractise.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.intercept.AuthorizationFilter;

@Configuration
public class SecurityConfig {
    private JwtFilter  jwtFilter;

    public SecurityConfig(JwtFilter jwtConfig) {
        this.jwtFilter= jwtConfig;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http.csrf().disable().cors().disable();
        http.addFilterBefore(jwtFilter, AuthorizationFilter.class);
        http.authorizeHttpRequests().anyRequest().permitAll();
//        http.authorizeHttpRequests().requestMatchers(
//                "/api/v1/RegUsers/signup-user",
//                "/api/v1/RegUsers/login",
//                "/api/v1/RegUsers/signup-owner")
//                .permitAll()
//                .requestMatchers("/api/v1/add-country/country").hasAnyRole("ADMIN","OWNER")
//                .anyRequest()
//                .authenticated();
        return http.build();
    }
}
