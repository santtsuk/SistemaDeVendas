package com.example.SistemaDeVendas.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "cpf", unique = true)
    private String cpf;

    @Column(name = "senha")
    private String senha;

    @OneToOne
    @JoinColumn(name = "id_funcionario")
    private Funcionario funcionario;

    @Column(name = "enabled")
    private boolean enabled;

    @OneToMany(mappedBy = "usuario")
    private List<Pedido> pedidos = new ArrayList<>();

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    private List<Roles> roles = new ArrayList<>();

    public Usuario(String cpf, String senha, Funcionario funcionario, boolean enabled) {
        this.cpf = cpf;
        this.senha = senha;
        this.funcionario = funcionario;
        this.enabled = enabled;

    }

    public Usuario() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public boolean isEnabled() { return enabled; }

    public void setEnabled(boolean enabled) { this.enabled = enabled; }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    public List<Roles> findRoles() { return roles; }

    public void setRoles(List<Roles> roles) { this.roles = roles; }
}