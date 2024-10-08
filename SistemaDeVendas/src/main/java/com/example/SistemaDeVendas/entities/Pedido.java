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
    private int idCliente;

    @Column(name = "valor_total")
    private float valorTotal;

    @Column(name = "id_pagamento")
    private int idPagamento;

    @Column(name = "id_usuario")
    private int idUsuario;

    public Pedido() {

    }

    public Pedido(int id, String dataPedido, int idCliente, float valorTotal, int idPagamento, int idUsuario) {
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

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public float getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(float valorTotal) {
        this.valorTotal = valorTotal;
    }

    public int getIdPagamento() {
        return idPagamento;
    }

    public void setIdPagamento(int idPagamento) {
        this.idPagamento = idPagamento;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
}