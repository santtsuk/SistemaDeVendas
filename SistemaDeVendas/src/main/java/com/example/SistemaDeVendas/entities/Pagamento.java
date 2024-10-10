package com.example.SistemaDeVendas.entities;

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
    @JoinColumn (name = "id_Pedido")
    private Pedido idPedido;

    @ManyToOne
    @JoinColumn (name = "id_pagamento")
    private TipoPagamento idPagamento;

    @Column(name = "valor")
    private float valor;

<<<<<<< Updated upstream
    @Column(name = "data_Pagamento")
    private LocalDate dataPagamento;

    public Pagamento(Pedido idPedido, TipoPagamento idPagamento, float valor,LocalDate dataPagamento) {
=======
    @Column(name = "data_pagamento")
    private LocalDate dataPagamento;

    public Pagamento(int id, Pedido idPedido, TipoPagamento idPagamento, float valor,LocalDate dataPagamento) {
        this.id = id;
>>>>>>> Stashed changes
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

    public LocalDate getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(LocalDate dataPagamento) {
        this.dataPagamento = dataPagamento;
    }
}