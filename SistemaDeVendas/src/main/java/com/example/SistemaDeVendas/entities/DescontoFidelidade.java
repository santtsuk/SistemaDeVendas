package com.example.SistemaDeVendas.entities;

public class DescontoFidelidade {

    private int id;
    private Cliente idCliente;
    private float valorDesconto;
    private String dataAplicacao;

    public DescontoFidelidade(int id, Cliente idCliente, float valorDesconto, String dataAplicacao) {
        this.id = id;
        this.idCliente = idCliente;
        this.valorDesconto = valorDesconto;
        this.dataAplicacao = dataAplicacao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Cliente getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Cliente idCliente) {
        this.idCliente = idCliente;
    }

    public float getValorDesconto() {
        return valorDesconto;
    }

    public void setValorDesconto(float valorDesconto) {
        this.valorDesconto = valorDesconto;
    }

    public String getDataAplicacao() {
        return dataAplicacao;
    }

    public void setDataAplicacao(String dataAplicacao) {
        this.dataAplicacao = dataAplicacao;
    }
}
