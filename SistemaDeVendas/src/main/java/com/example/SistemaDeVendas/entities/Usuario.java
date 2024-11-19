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

    @Column(name = "cpf",unique = true)
    private String cpf;

    @Column(name = "senha")
    private String senha;

    @OneToOne
    @JoinColumn(name = "id_funcionario")
    private Funcionario funcionario;

    @OneToMany(mappedBy = "usuario")
    private List<Pedido> pedidos  = new ArrayList<>();

    public Usuario(String cpf, String senha,Funcionario funcionario ) {
        this.cpf = cpf;
        this.senha = senha;
        this.funcionario = funcionario;

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

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }
}