package com.example.SistemaDeVendas.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "pedido")
public class Pedido {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "data_pedido")
    private LocalDate dataPedido;

    @ManyToOne
    @JoinColumn (name = "id_cliente")
    private Cliente cliente;

    @Column(name = "valor_total")
    private float valorTotal;

    @ManyToOne
    @JoinColumn (name = "id_pagamento")
    private Pagamento idPagamento;

    @ManyToOne
    @JoinColumn (name = "id_usuario")
    private Usuario idUsuario;

    @OneToMany(mappedBy = "pedido",cascade = CascadeType.ALL)
    private List<ItemPedido> itemPedidos;

    public Pedido() {
        this.itemPedidos = new ArrayList<>();
    }

    public Pedido(LocalDate dataPedido, Cliente idCliente, float valorTotal, Pagamento idPagamento, Usuario idUsuario) {

        this.dataPedido = dataPedido;
        this.cliente = idCliente;
        this.valorTotal = valorTotal;
        this.idPagamento = idPagamento;
        this.idUsuario = idUsuario;
        this.itemPedidos = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(LocalDate dataPedido) {
        this.dataPedido = dataPedido;
    }

    public Cliente getIdCliente() {
        return cliente;
    }

    public void setIdCliente(Cliente idCliente) {
        this.cliente = idCliente;
    }

    public float getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(float valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Pagamento getIdPagamento() {
        return idPagamento;
    }

    public void setIdPagamento(Pagamento idPagamento) {
        this.idPagamento = idPagamento;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }

    public List<ItemPedido> getItemPedidos() {
        return itemPedidos;
    }

    public void setItemPedidos(List<ItemPedido> itemPedidos) {
        this.itemPedidos = itemPedidos;
    }
}