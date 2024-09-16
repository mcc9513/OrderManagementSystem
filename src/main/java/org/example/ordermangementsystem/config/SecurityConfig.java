package org.example.ordermangementsystem.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authorizeRequests ->
                        authorizeRequests
                                .requestMatchers("/h2/**").permitAll()  // Allow access to the H2 console
                                .anyRequest().authenticated()
                )
                .csrf(csrf -> csrf
                        .ignoringRequestMatchers("/h2/**")  // Disable CSRF protection for the H2 console
                )
                .headers(headers -> headers
                        .frameOptions(frameOptions -> frameOptions.disable())  // Disable frame options to allow H2 console in iframes
                );

        return http.build();
    }
}
