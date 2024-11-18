package com.example.SistemaDeVendas.entities;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "funcionario")
public class Funcionario {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "cpf",unique = true)
    private String cpf;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn (name = "id_cargo")
    private Cargo cargo;

    @Column(name = "setor")
    private String setor;

    @Column(name = "data_admissao")
    private LocalDate dataAdmissao;

    @OneToOne(mappedBy = "funcionario")
    private Usuario usuario;

    public Funcionario(String nome, String cpf, Cargo cargo, String setor, LocalDate dataAdmissao) {
        this.nome = nome;
        this.cpf = cpf;
        this.cargo = cargo;
        this.setor = setor;
        this.dataAdmissao = dataAdmissao;
    }

    public Funcionario() {
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

    public LocalDate getDataAdimissao() {
        return dataAdmissao;
    }

    public void setDataAdimissao(LocalDate dataAdimissao) {
        this.dataAdmissao = dataAdimissao;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}