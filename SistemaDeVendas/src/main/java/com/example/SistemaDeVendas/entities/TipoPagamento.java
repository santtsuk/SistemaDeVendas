package com.example.SistemaDeVendas.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "tipo_Pagamento")
public class TipoPagamento {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "descricao")
    private String descricao;

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
}