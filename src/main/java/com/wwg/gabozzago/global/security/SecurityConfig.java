package com.wwg.gabozzago.global.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wwg.gabozzago.global.security.exception.handler.JwtExceptionHandler;
import com.wwg.gabozzago.global.security.filter.JwtTokenFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsUtils;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {
    private final ObjectMapper objectMapper;
    private final JwtTokenProvider jwtTokenProvider;
    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception {
        return http
                .cors().disable()
                .formLogin().disable()
                .csrf().disable()

                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)

                .and()
                .authorizeRequests()
                .requestMatchers(CorsUtils::isPreFlightRequest).permitAll()

                .antMatchers(HttpMethod.POST,"/auth/oauth").permitAll()

                .anyRequest().denyAll()
                .and()

                .exceptionHandling().authenticationEntryPoint(new CustomAuthenticationEntryPoint(objectMapper))
                .and()

                .addFilterAfter(new JwtTokenFilter(jwtTokenProvider), UsernamePasswordAuthenticationFilter.class)
                .addFilterBefore(new JwtExceptionHandler(objectMapper),UsernamePasswordAuthenticationFilter.class)
                .build();

    }
    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}