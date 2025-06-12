public class CartaoCredito extends Pagamento {
    private String numeroCartao;

    public CartaoCredito(String numeroCartao) {
        this.numeroCartao = numeroCartao;
    }

    @Override
    public boolean processarPagamento(double valor) {
        System.out.println("Processando pagamento via cartão de crédito no valor de R$ " + valor);
        this.status = "Pago";
        return true;
    }
}