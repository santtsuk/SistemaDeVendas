package com.example.SistemaDeVendas.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Entity
@Table(name = "produto")
public class Produto {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "codigo_barras")
    private String codigoBarras;

    @Column(name = "nome")
    private String nome;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "preco")
    private float preco;

    @Column(name = "estoque")
    private int estoque;

    @Column(name = "min_estoque")
    private int minEstoque;

    @OneToMany(mappedBy = "produto",cascade = CascadeType.ALL)
    private List<ItemPedido> itemPedidos  = new ArrayList<>();

    public Produto( String codigoBarras, String nome, String descricao, float preco, int estoque, int minEstoque) {
        this.codigoBarras = codigoBarras;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.estoque = estoque;
        this.minEstoque = minEstoque;
    }

    public Produto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodigoBarras() {
        return codigoBarras;
    }

    public void setCodigoBarras(String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }

    public int getMinEstoque() {
        return minEstoque;
    }

    public void setMinEstoque(int minEstoque) {
        this.minEstoque = minEstoque;
    }

    public void setItemPedidos(List<ItemPedido> itemPedidos) {
        this.itemPedidos = itemPedidos;
    }
}