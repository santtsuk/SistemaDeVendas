package com.example.SistemaDeVendas.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "funcionario")
public class Funcionario {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "cpf")
    private String cpf;

    @Column(name = "cargo")
    private String cargo;

    @Column(name = "setor")
    private String setor;

    @Column(name = "data_adimissao")
    private String dataAdimissao;

    public Funcionario(int id, String nome, String cpf, String cargo, String setor, String dataAdimissao) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.cargo = cargo;
        this.setor = setor;
        this.dataAdimissao = dataAdimissao;
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

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

    public String getDataAdimissao() {
        return dataAdimissao;
    }

    public void setDataAdimissao(String dataAdimissao) {
        this.dataAdimissao = dataAdimissao;
    }
}