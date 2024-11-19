package com.example.SistemaDeVendas.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tipo_pagamento")
public class TipoPagamento {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "descricao")
    private String descricao;

    @OneToMany(mappedBy = "tipoPagamento",cascade = CascadeType.ALL)
    private List<Pagamento> pagamentos  = new ArrayList<>();

    public TipoPagamento(String descricao) {
        this.descricao = descricao;
    }

    public TipoPagamento() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setPagamentos(List<Pagamento> pagamentos) {
        this.pagamentos = pagamentos;
    }
}