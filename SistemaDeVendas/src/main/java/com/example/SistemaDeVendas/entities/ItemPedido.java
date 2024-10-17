package com.example.SistemaDeVendas.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "item_Pedido")
public class ItemPedido {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn (name = "id_Pedido")
    private Pedido pedido;

    @ManyToOne
    @JoinColumn (name = "id_produto")
    private Produto produto;

    @Column(name = "quantidade")
    private int quantidade;

    @Column(name = "preco_unitario")
    private float precoUnitario;

    public ItemPedido(Pedido idPedido, Produto idProduto, int quantidade, float precoUnitario) {
        this.pedido = idPedido;
        this.produto = idProduto;
        this.quantidade = quantidade;
        this.precoUnitario = precoUnitario;
    }

    public ItemPedido() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Pedido getIdPedido() {
        return pedido;
    }

    public void setIdPedido(Pedido idPedido) {
        this.pedido = idPedido;
    }

    public Produto getIdProduto() {
        return produto;
    }

    public void setIdProduto(Produto idProduto) {
        this.produto = idProduto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public float getPrecoUnitario() {
        return precoUnitario;
    }

    public void setPrecoUnitario(float precoUnitario) {
        this.precoUnitario = precoUnitario;
    }
}