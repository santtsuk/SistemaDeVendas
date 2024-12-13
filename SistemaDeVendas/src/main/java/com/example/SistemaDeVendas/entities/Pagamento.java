package com.example.SistemaDeVendas.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

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

    public PedidosRecord getPedido() {
        return new PedidosRecord(pedido.getId(),pedido.getDataPedido());
    }

    public void setPedido(Pedido pedido) {
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


}
