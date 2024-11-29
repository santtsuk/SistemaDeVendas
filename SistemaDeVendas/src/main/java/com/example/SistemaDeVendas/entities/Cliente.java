package com.example.SistemaDeVendas.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "cliente")
public class Cliente {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "cpf" ,unique = true)
    private String cpf;

    @Column(name = "telefone")
    private String telefone;

    @Column(name = "email")
    private String email;

    @Column(name = "endereco")
    private String endereco;

    @Enumerated(EnumType.STRING)
    @JoinColumn (name = "categoria")
    private Categorias categoria;

    @OneToMany(mappedBy = "cliente",cascade = CascadeType.ALL)
    private List<Pedido> pedidos  = new ArrayList<>();

    @OneToMany(mappedBy = "cliente",cascade = CascadeType.ALL)
    private List<DescontoFidelidade> descontoFidelidades  = new ArrayList<>();

    public Cliente(String nome, String cpf, String telefone, String email, String endereco) {
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.email = email;
        this.endereco = endereco;
        this.categoria = Categorias.SEM_CATEGORIA;

    }

    public Cliente() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Categorias getCategoria() {return categoria;}

    public void setCategoria(Categorias categoria) {this.categoria = categoria;}

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    public void setDescontoFidelidades(List<DescontoFidelidade> descontoFidelidades) {
        this.descontoFidelidades = descontoFidelidades;
    }

    
}
