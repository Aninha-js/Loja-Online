import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private String nome;
    private String email;
    private String senha;
    private String endereco;
    private List<Pedido> pedidos = new ArrayList<>();

    public Cliente(String nome, String email, String senha, String endereco) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.endereco = endereco;
    }

    public void adicionarPedido(Pedido pedido) {
        pedidos.add(pedido);
    }
}