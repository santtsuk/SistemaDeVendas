@Service
public class PagamentoApplication implements IPagamento {

    private final PagamentoRepositoryMySql pagamentoRepository;
    private final DescontoFidelidadeRepository descontoFidelidadeRepository;
    private final PedidoRepository pedidoRepository;

    @Autowired
    public PagamentoApplication(PagamentoRepositoryMySql pagamentoRepository,
                                DescontoFidelidadeRepository descontoFidelidadeRepository,
                                PedidoRepository pedidoRepository) {
        this.pagamentoRepository = pagamentoRepository;
        this.descontoFidelidadeRepository = descontoFidelidadeRepository;
        this.pedidoRepository = pedidoRepository;
    }

    public Pagamento buscarPorId(int id) {
        return this.pagamentoRepository.buscarPorId(id);
    }

    public List<Pagamento> buscarTodos() {
        return this.pagamentoRepository.buscarTodos();
    }

    public void salvar(Pagamento pagamento) {
        Pedido pedido = pagamento.getPedido();

        if (pagamento.getDescontoFidelidade() != null) {
            DescontoFidelidade desconto = descontoFidelidadeRepository.buscarPorId(pagamento.getDescontoFidelidade().getId())
                .orElseThrow(() -> new RegraNegocioException("Desconto não encontrado."));

            if (desconto.getDataAplicacao().isBefore(LocalDate.now())) {
                throw new RegraNegocioException("Desconto expirado.");
            }

            BigDecimal valorDesconto = BigDecimal.valueOf(desconto.getValorDesconto());
            BigDecimal valorTotalAtual = BigDecimal.valueOf(pedido.getValorTotal());

            
            if (valorDesconto.compareTo(valorTotalAtual) > 0) {
                throw new RegraNegocioException("O valor do desconto não pode ser maior que o total do pedido.");
            }

            
            BigDecimal novoValorTotal = valorTotalAtual.subtract(valorDesconto);
            pedido.setValorTotal(novoValorTotal.floatValue());
            pedidoRepository.atualizar(pedido.getId(), pedido);
        }
        this.pagamentoRepository.salvar(pagamento);

        
        pedido.atualizarStatusPagamento();
        this.pedidoRepository.atualizar(pedido.getId(), pedido);
    }

    public void atualizar(int id, Pagamento pagamento) {
        Pagamento pagamentoInDB = this.pagamentoRepository.buscarPorId(id);

        if (pagamentoInDB == null) {
            throw new RegraNegocioException("Pagamento não encontrado.");
        }

        this.pagamentoRepository.atualizar(id, pagamento);
    }

    public void deletar(int id) {
        Pagamento pagamentoInDB = this.pagamentoRepository.buscarPorId(id);

        if (pagamentoInDB == null) {
            throw new RegraNegocioException("Pagamento não encontrado.");
        }

        this.pagamentoRepository.deletar(id);
    }
}
