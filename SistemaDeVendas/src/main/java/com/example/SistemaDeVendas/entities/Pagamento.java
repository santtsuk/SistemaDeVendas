package com.example.SistemaDeVendas.entities;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "pagamento")
public class Pagamento {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "id_pedido")
    private Pedido pedido;

    @ManyToOne
    @JoinColumn(name = "id_tipo_pagamento")
    private TipoPagamento tipoPagamento;

    @Column(name = "valor")
    private float  valor;

    @Column(name = "data_Pagamento")
    private LocalDate dataPagamento;


    @OneToOne
    @JoinColumn(name = "desconto_fidelidade")
    private DescontoFidelidade descontoFidelidade;


    public Pagamento(Pedido pedido, TipoPagamento tipoPagamento, float  valor, LocalDate dataPagamento, DescontoFidelidade descontoFidelidade) {
        this.pedido = pedido;
        this.tipoPagamento = tipoPagamento;
        this.valor = valor;
        this.dataPagamento = dataPagamento;
        this.descontoFidelidade = descontoFidelidade;
    }


    public Pagamento(Pedido pedido, TipoPagamento tipoPagamento, float  valor, LocalDate dataPagamento) {
        this.pedido = pedido;
        this.tipoPagamento = tipoPagamento;
        this.valor = valor;
        this.dataPagamento = dataPagamento;
    }

    public Pagamento() {
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setIdPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public TipoPagamento getIdPagamento() {
        return tipoPagamento;
    }

    public void setIdPagamento(TipoPagamento tipoPagamento) {
        this.tipoPagamento = tipoPagamento;
    }

    public float  getValor() {
        return valor;
    }

    public void setValor(float  valor) {
        this.valor = valor;
    }

    public LocalDate getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(LocalDate dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public DescontoFidelidade getDescontoFidelidade() {
        return descontoFidelidade;
    }

    public void setDescontoFidelidade(DescontoFidelidade descontoFidelidade) {
        this.descontoFidelidade = descontoFidelidade;
    }
}
