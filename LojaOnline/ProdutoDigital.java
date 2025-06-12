public class ProdutoDigital extends Produto {
    private String urlDownload;
    private int tamanhoMB;

    public ProdutoDigital(String nome, double preco, String descricao, String urlDownload, int tamanhoMB) {
        super(nome, preco, descricao);
        this.urlDownload = urlDownload;
        this.tamanhoMB = tamanhoMB;
    }
}