public class Boleto extends Pagamento {
    private String codigoBarras;

    public Boleto(String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    @Override
    public boolean processarPagamento(double valor) {
        System.out.println("Processando pagamento via boleto no valor de R$ " + valor);
        this.status = "Pago";
        return true;
    }
}