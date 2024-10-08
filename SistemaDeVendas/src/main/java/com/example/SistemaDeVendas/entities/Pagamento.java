package com.example.SistemaDeVendas.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "pagamento")
public class Pagamento {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "id_pedido")
    private Pedido idPedido;

    @Column(name = "id_pagamento")
    private TipoPagamento idPagamento;

    @Column(name = "valor")
    private float valor;

    public Pagamento(int id, Pedido idPedido, TipoPagamento idPagamento, float valor) {
        this.id = id;
        this.idPedido = idPedido;
        this.idPagamento = idPagamento;
        this.valor = valor;
    }

    public Pagamento() {
    }

    public int getId() {return id;}

    public void setId(int id) {
        this.id = id;
    }

    public Pedido getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Pedido idPedido) {
        this.idPedido = idPedido;
    }

    public TipoPagamento getIdPagamento() {
        return idPagamento;
    }

    public void setIdPagamento(TipoPagamento idPagamento) {
        this.idPagamento = idPagamento;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }
}