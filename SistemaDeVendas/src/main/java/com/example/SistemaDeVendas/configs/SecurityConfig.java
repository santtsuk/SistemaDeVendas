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

            jdbcUserDetailsManager.setUsersByUsernameQuery("SELECT username, password, enabled FROM user where username = ?");

            jdbcUserDetailsManager.setAuthoritiesByUsernameQuery("select username, role from user inner join role on user.id = role.user_id where username = ?");

            return jdbcUserDetailsManager;
        }
}
