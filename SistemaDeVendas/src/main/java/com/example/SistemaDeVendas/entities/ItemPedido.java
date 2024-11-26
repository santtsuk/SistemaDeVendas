package com.example.SistemaDeVendas.entities;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "item_Pedido")
public class ItemPedido {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn (name = "id_pedido")
    private Pedido pedido;

    @ManyToOne
    @JoinColumn (name = "id_produto")
    private Produto produto;

    @Column(name = "quantidade")
    private int quantidade;

    @Column(name = "preco_unitario")
    private float precoUnitario;

    public ItemPedido(Pedido pedido, Produto produto, int quantidade, float precoUnitario) {
        this.pedido = pedido;
        this.produto = produto;
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


    public void setIdPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Produto getIdProduto() {
        return produto;
    }

    public void setIdProduto(Produto produto) {
        this.produto = produto;
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

    public float calcularTotal(){
        float totalItem = this.quantidade * this.precoUnitario;
        return totalItem;
    }
}