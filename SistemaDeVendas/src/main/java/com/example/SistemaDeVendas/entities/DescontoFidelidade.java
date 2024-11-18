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

    @OneToOne(mappedBy = "descontoFidelidade",cascade = CascadeType.ALL)
    private Pagamento pagamento;

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

    public Cliente getCliente() {
        return cliente;
    }

    public void setIdCliente(Cliente cliente) {
        this.cliente = cliente;
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

    public Pagamento getPagamento() {
        return pagamento;
    }

    public void setPagamento(Pagamento pagamento) {
        this.pagamento = pagamento;
    }
}
