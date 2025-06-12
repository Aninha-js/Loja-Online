public abstract class Produto {
    protected String nome;
    protected double preco;
    protected String descricao;

    public Produto(String nome, double preco, String descricao) {
        this.nome = nome;
        this.preco = preco;
        this.descricao = descricao;
    }

    public double getPreco() {
        return preco;
    }

    public String getNome() {
        return nome;
    }
}