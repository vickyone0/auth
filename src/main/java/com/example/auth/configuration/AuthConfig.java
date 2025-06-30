package com.example.auth.configuration;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class AuthConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {

        return new BCryptPasswordEncoder(11);

    }

    @Bean
    public SecurityFilterChain SecurityFilterChainAuth(HttpSecurity httpSecurity) throws Exception {

        httpSecurity.csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(
                    authorizeRequests -> authorizeRequests
                        .requestMatchers("/register")
                        .permitAll()
                        .anyRequest()
                        .authenticated())
                        .formLogin(formLogin -> formLogin.defaultSuccessUrl("/h2-console",true).permitAll());
        return httpSecurity.build();
    }
    
}
