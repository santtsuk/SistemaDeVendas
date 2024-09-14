package com.example.SistemaDeVendas.entities;

public class Pagamento {

    private int id;
    private Pedido idPedido;
    private TipoPagamento idPagamento;
    private float valor;

    public Pagamento(int id, Pedido idPedido, TipoPagamento idPagamento, float valor) {
        this.id = id;
        this.idPedido = idPedido;
        this.idPagamento = idPagamento;
        this.valor = valor;
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
