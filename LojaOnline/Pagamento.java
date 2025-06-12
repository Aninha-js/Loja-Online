public abstract class Pagamento {
    protected String status;

    public abstract boolean processarPagamento(double valor);

    public String getStatus() {
        return status;
    }
}