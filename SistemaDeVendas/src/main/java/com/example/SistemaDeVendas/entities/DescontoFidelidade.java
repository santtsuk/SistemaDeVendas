package com.example.SistemaDeVendas.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "desconto_fidelidade")
public class DescontoFidelidade {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn (name = "id_Cliente")
    private Cliente cliente;

    @Column(name = "valor_Desconto")
    private float valorDesconto;

    @Column(name = "data_Aplicacao")
    private LocalDate dataAplicacao;

    public DescontoFidelidade(Cliente cliente, float valorDesconto, LocalDate dataAplicacao) {
        this.cliente = cliente;
        this.valorDesconto = valorDesconto;
        this.dataAplicacao = dataAplicacao;
    }

    public DescontoFidelidade() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Cliente getIdCliente() {
        return cliente;
    }

    public void setIdCliente(Cliente idCliente) {
        this.cliente = idCliente;
    }

    public float getValorDesconto() {
        return valorDesconto;
    }

    public void setValorDesconto(float valorDesconto) {
        this.valorDesconto = valorDesconto;
    }

    public LocalDate getDataAplicacao() {
        return dataAplicacao;
    }

    public void setDataAplicacao(LocalDate dataAplicacao) {
        this.dataAplicacao = dataAplicacao;
    }
}
