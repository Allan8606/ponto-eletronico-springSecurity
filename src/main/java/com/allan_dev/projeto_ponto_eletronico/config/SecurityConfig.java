package com.allan_dev.projeto_ponto_eletronico.config;


import com.allan_dev.projeto_ponto_eletronico.security.SecurityFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final SecurityFilter securityFilter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .csrf(csrf -> csrf.disable())
                .sessionManagement(sm -> sm.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(req -> {

                    req.requestMatchers(HttpMethod.POST, "/login").permitAll();

                    req.requestMatchers(HttpMethod.POST, "/funcionario").permitAll();
                    req.requestMatchers(HttpMethod.GET, "/funcionario/**").permitAll();

                    req.requestMatchers(HttpMethod.DELETE, "/funcionario/**").hasAuthority("ADMIN");
                    req.requestMatchers(HttpMethod.PUT, "/funcionario/**").hasAuthority("ADMIN");

                    req.requestMatchers(HttpMethod.GET, "/registroPonto/**").hasAuthority("ADMIN");
                    req.requestMatchers(HttpMethod.PUT, "/registroPonto/**").hasAuthority("ADMIN");
                    req.requestMatchers(HttpMethod.DELETE, "/registroPonto/**").hasAuthority("ADMIN");

                    req.requestMatchers(HttpMethod.GET, "/api/api-docs/**").permitAll();
                    req.requestMatchers(HttpMethod.GET, "/swagger/**").permitAll();

                    // O resto precisa pelo menos ter crachá
                    req.anyRequest().authenticated();
                })
                .addFilterBefore(securityFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }

}
