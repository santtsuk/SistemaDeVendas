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
    @JoinColumn (name = "id_usuario")
    private Usuario usuario;

    @Enumerated(EnumType.STRING)
    @JoinColumn (name = "status")
    private StatusPedido status;

    @OneToMany(mappedBy= "pedido",cascade = CascadeType.ALL)
    private List<Pagamento> pagamentos  = new ArrayList<>();

    @OneToMany(mappedBy = "pedido",cascade = CascadeType.ALL)
    private List<ItemPedido> itemPedidos  = new ArrayList<>();

    public Pedido() {

    }

    public Pedido(LocalDate dataPedido, Cliente cliente, float valorTotal, Usuario usuario) {

        this.dataPedido = dataPedido;
        this.cliente = cliente;
        this.valorTotal = valorTotal;
        this.usuario = usuario;
        this.status = StatusPedido.PENDENTE;
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

    public void setIdCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public float getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(float valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Usuario getIdUsuario() {
        return usuario;
    }

    public void setIdUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public StatusPedido getStatus(){
        return status;
    }

    public void setStatus(StatusPedido status) {
        this.status = status;
    }

    public List<Pagamento> getPagamentos() {
        return pagamentos;
    }

    public void setPagamentos(List<Pagamento> pagamentos) {
        this.pagamentos = pagamentos;
    }

    public List<ItemPedido> getItemPedidos() {
        return itemPedidos;
    }

    public void setItemPedidos(List<ItemPedido> itemPedidos) {
        this.itemPedidos = itemPedidos;
    }

    public void calcularValorTotal() {
        this.valorTotal = itemPedidos.stream()
                .map(ItemPedido::calcularTotal)
                .reduce(0f, Float::sum);
    }

    public void atualizarStatusPagamento() {
        float totalPago = pagamentos.stream()
                .map(Pagamento::getValor)
                .filter(valor -> valor != null)
                .reduce(0f, Float::sum);
        if (totalPago > valorTotal && totalPago > 0) {
            this.status = StatusPedido.PARCIALMENTE_PAGO;
        } else if (totalPago == valorTotal) {
            this.status = StatusPedido.PAGO;
        } else {
            this.status = StatusPedido.PENDENTE;
        }
    }

    public boolean verificaItemExistente() {
        return this.itemPedidos == null || this.itemPedidos.isEmpty();
    }

    public void aplicarDesconto(float valor){
        this.valorTotal = valorTotal - valor;
    }


}