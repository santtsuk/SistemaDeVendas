package com.example.SistemaDeVendas.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.CsrfDsl;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class SecurityConfig {
    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource) {
        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);

        jdbcUserDetailsManager.setUsersByUsernameQuery("SELECT cpf, senha, enabled FROM usuario where cpf = ?");

        jdbcUserDetailsManager.setAuthoritiesByUsernameQuery("select cpf, role from usuario inner join role on usuario.id = role.usuario_id where cpf = ?");

        return jdbcUserDetailsManager;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeHttpRequests(configurer -> {
            configurer
                    
//                         CONFIGURAÇÃO USADA COMO REFERENCIA

//                        .requestMatchers(HttpMethod.GET, "/api/teachers/").hasRole("TEACHER")
//                        .requestMatchers(HttpMethod.GET, "/api/teachers/**").hasRole("TEACHER")
//                        .requestMatchers(HttpMethod.POST, "/api/teachers/").hasRole("COORDINATOR")
//                        .requestMatchers(HttpMethod.PUT, "/api/teachers/**").hasRole("COORDINATOR")
//                        .requestMatchers(HttpMethod.DELETE, "/api/teachers/**").hasRole("ADMIN")
//                        .requestMatchers("/api/users/**").permitAll();

                    .requestMatchers(HttpMethod.GET, "cargo/buscartodos/").hasRole("ADMIN")
                    .requestMatchers(HttpMethod.GET, "cargo/buscarPorID/**").hasRole("ADMIN")
                    .requestMatchers(HttpMethod.POST, "cargo/").hasRole("ADMIN")
                    .requestMatchers(HttpMethod.PUT, "cargo/").hasRole("ADMIN")
                    .requestMatchers(HttpMethod.DELETE, "cargo/").hasRole("ADMIN")

                    .requestMatchers(HttpMethod.GET, "cargo/buscartodos/").hasRole("GERENTE")
                    .requestMatchers(HttpMethod.GET, "cargo/buscarPorID/**").hasRole("GERENTE")
                    .requestMatchers(HttpMethod.POST, "cargo/").hasRole("GERENTE")
                    .requestMatchers(HttpMethod.PUT, "cargo/").hasRole("GERENTE")
                    .requestMatchers("/usuario/**").permitAll();


        });

        httpSecurity.httpBasic(Customizer.withDefaults());

        httpSecurity.csrf(csrf -> csrf.disable());

        return httpSecurity.build();
    }
}
