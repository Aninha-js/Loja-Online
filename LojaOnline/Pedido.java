import java.util.List;

public class Pedido {
    private int numeroPedido;
    private List<ItemPedido> itens;
    private Pagamento pagamento;

    public Pedido(int numeroPedido, List<ItemPedido> itens, Pagamento pagamento) {
        this.numeroPedido = numeroPedido;
        this.itens = itens;
        this.pagamento = pagamento;
    }

    public void processarPagamento() {
        double total = 0.0;
        for (ItemPedido item : itens) {
            total += item.getProduto().getPreco() * item.getQuantidade();
        }
        if (pagamento.processarPagamento(total)) {
            System.out.println("Status do pedido: " + pagamento.getStatus());
        }
    }

    public void exibirResumo() {
        for (ItemPedido item : itens) {
            System.out.println("- " + item.getProduto().getNome() + ": " + item.getQuantidade());
        }
    }
}