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
                    
//-------------------------- CONFIGURAÇÃO USADA COMO REFERENCIA
//                        .requestMatchers(HttpMethod.GET, "/api/teachers/").hasRole("TEACHER")
//                        .requestMatchers(HttpMethod.GET, "/api/teachers/**").hasRole("TEACHER")
//                        .requestMatchers(HttpMethod.POST, "/api/teachers/").hasRole("COORDINATOR")
//                        .requestMatchers(HttpMethod.PUT, "/api/teachers/**").hasRole("COORDINATOR")
//                        .requestMatchers(HttpMethod.DELETE, "/api/teachers/**").hasRole("ADMIN")
//                        .requestMatchers("/api/users/**").permitAll();

//-------------------------- CONFIRGURAÇÃO DE AUTENTIFICAÇÃO DA CLASSE CARGO 
                    .requestMatchers(HttpMethod.GET, "cargo/buscartodos/").hasRole("ADMIN")
                    .requestMatchers(HttpMethod.GET, "cargo/buscarPorID/**").hasRole("ADMIN")
                    .requestMatchers(HttpMethod.POST, "cargo/").hasRole("ADMIN")
                    .requestMatchers(HttpMethod.PUT, "cargo/").hasRole("ADMIN")
                    .requestMatchers(HttpMethod.DELETE, "cargo/").hasRole("ADMIN")

                    .requestMatchers(HttpMethod.GET, "cargo/buscartodos/").hasRole("GERENTE")
                    .requestMatchers(HttpMethod.GET, "cargo/buscarPorID/**").hasRole("GERENTE")
                    .requestMatchers(HttpMethod.POST, "cargo/").hasRole("GERENTE")
                    .requestMatchers(HttpMethod.PUT, "cargo/").hasRole("GERENTE")
                    
            
//-------------------------- CONFIRGURAÇÃO DE AUTENTIFICAÇÃO DA CLASSE CLIENTE
                    .requestMatchers(HttpMethod.GET, "cliente/buscartodos/").hasRole("ADMIN")
                    .requestMatchers(HttpMethod.GET, "cliente/buscarPorID/**").hasRole("ADMIN")
                    .requestMatchers(HttpMethod.POST, "cliente/").hasRole("ADMIN")
                    .requestMatchers(HttpMethod.PUT, "cliente/").hasRole("ADMIN")
                    .requestMatchers(HttpMethod.DELETE, "cliente/").hasRole("ADMIN")

                    .requestMatchers(HttpMethod.GET, "cliente/buscartodos/").hasRole("GERENTE")
                    .requestMatchers(HttpMethod.GET, "cliente/buscarPorID/**").hasRole("GERENTE")
                    .requestMatchers(HttpMethod.POST, "cliente/").hasRole("GERENTE")
                    .requestMatchers(HttpMethod.PUT, "cliente/").hasRole("GERENTE")

//-------------------------- CONFIRGURAÇÃO DE AUTENTIFICAÇÃO DA CLASSE DESCONTO FIDELIDADE
                    .requestMatchers(HttpMethod.GET, "descontoFidelidade/buscartodos/").hasRole("ADMIN")
                    .requestMatchers(HttpMethod.GET, "descontoFidelidade/buscarPorID/**").hasRole("ADMIN")
                    .requestMatchers(HttpMethod.POST, "descontoFidelidade/").hasRole("ADMIN")
                    .requestMatchers(HttpMethod.PUT, "descontoFidelidade/").hasRole("ADMIN")
                    .requestMatchers(HttpMethod.DELETE, "descontoFidelidade/").hasRole("ADMIN")

                    .requestMatchers(HttpMethod.GET, "descontoFidelidade/buscartodos/").hasRole("GERENTE")
                    .requestMatchers(HttpMethod.GET, "descontoFidelidade/buscarPorID/**").hasRole("GERENTE")
                    .requestMatchers(HttpMethod.POST, "descontoFidelidade/").hasRole("GERENTE")
                    .requestMatchers(HttpMethod.PUT, "descontoFidelidade/").hasRole("GERENTE")

//-------------------------- CONFIRGURAÇÃO DE AUTENTIFICAÇÃO DA CLASSE FUNCIONARIO
                    .requestMatchers(HttpMethod.GET, "funcionario/buscartodos/").hasRole("ADMIN")
                    .requestMatchers(HttpMethod.GET, "funcionario/buscarPorID/**").hasRole("ADMIN")
                    .requestMatchers(HttpMethod.POST, "funcionario/").hasRole("ADMIN")
                    .requestMatchers(HttpMethod.PUT, "funcionario/").hasRole("ADMIN")
                    .requestMatchers(HttpMethod.DELETE, "funcionario/").hasRole("ADMIN")

                    .requestMatchers(HttpMethod.GET, "funcionario/buscartodos/").hasRole("GERENTE")
                    .requestMatchers(HttpMethod.GET, "funcionario/buscarPorID/**").hasRole("GERENTE")
                    .requestMatchers(HttpMethod.POST, "funcionario/").hasRole("GERENTE")
                    .requestMatchers(HttpMethod.PUT, "funcionario/").hasRole("GERENTE")

//-------------------------- CONFIRGURAÇÃO DE AUTENTIFICAÇÃO DA CLASSE ITEM PEDIDO
                    .requestMatchers(HttpMethod.GET, "itemPedido/buscartodos/").hasRole("ADMIN")
                    .requestMatchers(HttpMethod.GET, "itemPedido/buscarPorID/**").hasRole("ADMIN")
                    .requestMatchers(HttpMethod.POST, "itemPedido/").hasRole("ADMIN")
                    .requestMatchers(HttpMethod.PUT, "itemPedido/").hasRole("ADMIN")
                    .requestMatchers(HttpMethod.DELETE, "itemPedido/").hasRole("ADMIN")

                    .requestMatchers(HttpMethod.GET, "itemPedido/buscartodos/").hasRole("GERENTE")
                    .requestMatchers(HttpMethod.GET, "itemPedido/buscarPorID/**").hasRole("GERENTE")
                    .requestMatchers(HttpMethod.POST, "itemPedido/").hasRole("GERENTE")
                    .requestMatchers(HttpMethod.PUT, "itemPedido/").hasRole("GERENTE")
                
//-------------------------- CONFIRGURAÇÃO DE AUTENTIFICAÇÃO DA CLASSE descontoFidelidade
                    .requestMatchers(HttpMethod.GET, "descontoFidelidade/buscartodos/").hasRole("ADMIN")
                    .requestMatchers(HttpMethod.GET, "descontoFidelidade/buscarPorID/**").hasRole("ADMIN")
                    .requestMatchers(HttpMethod.POST, "descontoFidelidade/").hasRole("ADMIN")
                    .requestMatchers(HttpMethod.PUT, "descontoFidelidade/").hasRole("ADMIN")
                    .requestMatchers(HttpMethod.DELETE, "descontoFidelidade/").hasRole("ADMIN")
                    
                    .requestMatchers(HttpMethod.GET, "descontoFidelidade/buscartodos/").hasRole("GERENTE")
                    .requestMatchers(HttpMethod.GET, "descontoFidelidade/buscarPorID/**").hasRole("GERENTE")
                    .requestMatchers(HttpMethod.POST, "descontoFidelidade/").hasRole("GERENTE")
                    .requestMatchers(HttpMethod.PUT, "descontoFidelidade/").hasRole("GERENTE")
                    .requestMatchers("/usuario/**").permitAll();
                    
                    
//-------------------------- CONFIRGURAÇÃO DE AUTENTIFICAÇÃO DA CLASSE produto
                    .requestMatchers(HttpMethod.GET, "produto/buscartodos/").hasRole("ADMIN")
                    .requestMatchers(HttpMethod.GET, "produto/buscarPorID/**").hasRole("ADMIN")
                    .requestMatchers(HttpMethod.POST, "produto/").hasRole("ADMIN")
                    .requestMatchers(HttpMethod.PUT, "produto/").hasRole("ADMIN")
                    .requestMatchers(HttpMethod.DELETE, "produto/").hasRole("ADMIN")
                    
                    .requestMatchers(HttpMethod.GET, "produto/buscartodos/").hasRole("GERENTE")
                    .requestMatchers(HttpMethod.GET, "produto/buscarPorID/**").hasRole("GERENTE")
                    .requestMatchers(HttpMethod.POST, "produto/").hasRole("GERENTE")
                    .requestMatchers(HttpMethod.PUT, "produto/").hasRole("GERENTE")
                    .requestMatchers("/usuario/**").permitAll();
                    
                    
//-------------------------- CONFIRGURAÇÃO DE AUTENTIFICAÇÃO DA CLASSE pedido
                    .requestMatchers(HttpMethod.GET, "pedido/buscartodos/").hasRole("ADMIN")
                    .requestMatchers(HttpMethod.GET, "pedido/buscarPorID/**").hasRole("ADMIN")
                    .requestMatchers(HttpMethod.POST, "pedido/").hasRole("ADMIN")
                    .requestMatchers(HttpMethod.PUT, "pedido/").hasRole("ADMIN")
                    .requestMatchers(HttpMethod.DELETE, "pedido/").hasRole("ADMIN")
                    
                    .requestMatchers(HttpMethod.GET, "pedido/buscartodos/").hasRole("GERENTE")
                    .requestMatchers(HttpMethod.GET, "pedido/buscarPorID/**").hasRole("GERENTE")
                    .requestMatchers(HttpMethod.POST, "pedido/").hasRole("GERENTE")
                    .requestMatchers(HttpMethod.PUT, "pedido/").hasRole("GERENTE")
                    .requestMatchers("/usuario/**").permitAll();
                    
                    
//-------------------------- CONFIRGURAÇÃO DE AUTENTIFICAÇÃO DA CLASSE pagamento
                    .requestMatchers(HttpMethod.GET, "pagamento/buscartodos/").hasRole("ADMIN")
                    .requestMatchers(HttpMethod.GET, "pagamento/buscarPorID/**").hasRole("ADMIN")
                    .requestMatchers(HttpMethod.POST, "pagamento/").hasRole("ADMIN")
                    .requestMatchers(HttpMethod.PUT, "pagamento/").hasRole("ADMIN")
                    .requestMatchers(HttpMethod.DELETE, "pagamento/").hasRole("ADMIN")
                    
                    .requestMatchers(HttpMethod.GET, "pagamento/buscartodos/").hasRole("GERENTE")
                    .requestMatchers(HttpMethod.GET, "pagamento/buscarPorID/**").hasRole("GERENTE")
                    .requestMatchers(HttpMethod.POST, "pagamento/").hasRole("GERENTE")
                    .requestMatchers(HttpMethod.PUT, "pagamento/").hasRole("GERENTE")
                    .requestMatchers("/usuario/**").permitAll();

                
//--------------------------CONFIRMAÇÃO DE ACESSO DO USUARIO
//                .requestMatchers("/usuario/**").permitAll();


        });

        httpSecurity.httpBasic(Customizer.withDefaults());

        httpSecurity.csrf(csrf -> csrf.disable());

        return httpSecurity.build();
    }
}
