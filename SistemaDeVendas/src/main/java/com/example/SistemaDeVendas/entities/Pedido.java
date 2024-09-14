package com.example.SistemaDeVendas.entities;

public class Pedido {

    private int id;
    private String dataPedido;
    private Cliente idCliente;
    private float valorTotal;
    private Pagamento idPagamento;
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
