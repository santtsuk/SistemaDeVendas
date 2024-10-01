package com.example.SistemaDeVendas.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "pedido")
public class Pedido {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "data_pedido")
    private String dataPedido;

    @Column(name = "id_cliente")
    private Cliente idCliente;

    @Column(name = "valor_total")
    private float valorTotal;

    @Column(name = "id_pagamento")
    private Pagamento idPagamento;

    @Column(name = "id_usuario")
    private Usuario idUsuario;

    public Pedido(int id, String dataPedido, Cliente idCliente, float valorTotal, Pagamento idPagamento, Usuario idUsuario) {
        this.id = id;
        this.dataPedido = dataPedido;
        this.idCliente = idCliente;
        this.valorTotal = valorTotal;
        this.idPagamento = idPagamento;
        this.idUsuario = idUsuario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(String dataPedido) {
        this.dataPedido = dataPedido;
    }

    public Cliente getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Cliente idCliente) {
        this.idCliente = idCliente;
    }

    public float getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(float valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Pagamento getIdPagamentos() {
        return idPagamento;
    }

    public void setIdPagamentos(Pagamento idPagamentos) {
        this.idPagamento = idPagamentos;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }
}
