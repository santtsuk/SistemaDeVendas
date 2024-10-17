package com.example.SistemaDeVendas.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "cpf",unique = true)
    private String cpf;

    @Column(name = "senha")
    private String senha;

    @ManyToOne
    @JoinColumn (name = "id_cargo")
    private Cargo cargo;

    @Column(name = "setor")
    private String setor;

    public Usuario(String nome, String cpf, String senha, Cargo cargo, String setor) {
        this.nome = nome;
        this.cpf = cpf;
        this.senha = senha;
        this.cargo = cargo;
        this.setor = setor;
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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }
}