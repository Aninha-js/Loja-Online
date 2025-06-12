import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Coletar dados do cliente
        System.out.print("Nome do cliente: ");
        String nome = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Senha: ");
        String senha = scanner.nextLine();
        System.out.print("Endereço: ");
        String endereco = scanner.nextLine();

        Cliente cliente = new Cliente(nome, email, senha, endereco);

        // Lista de itens
        List<ItemPedido> itens = new ArrayList<>();

        while (true) {
            System.out.println("\n=== Adicionar Produto ===");
            System.out.print("Nome do produto: ");
            String nomeProduto = scanner.nextLine();
            System.out.print("Preço do produto: ");
            double preco = Double.parseDouble(scanner.nextLine());
            System.out.print("Descrição do produto: ");
            String descricao = scanner.nextLine();

            System.out.print("Tipo (1 - Físico | 2 - Digital): ");
            int tipo = Integer.parseInt(scanner.nextLine());

            Produto produto;
            if (tipo == 1) {
                System.out.print("Peso do produto (kg): ");
                double peso = Double.parseDouble(scanner.nextLine());
                produto = new ProdutoFisico(nomeProduto, preco, descricao, peso);
            } else {
                System.out.print("URL para download: ");
                String url = scanner.nextLine();
                System.out.print("Tamanho do arquivo (MB): ");
                int tamanho = Integer.parseInt(scanner.nextLine());
                produto = new ProdutoDigital(nomeProduto, preco, descricao, url, tamanho);
            }

            System.out.print("Quantidade: ");
            int quantidade = Integer.parseInt(scanner.nextLine());

            itens.add(new ItemPedido(produto, quantidade));

            System.out.print("Adicionar outro produto? (s/n): ");
            String continuar = scanner.nextLine();
            if (!continuar.equalsIgnoreCase("s")) break;
        }

        // Escolher forma de pagamento
        System.out.println("\n=== Forma de Pagamento ===");
        System.out.println("1 - Boleto");
        System.out.println("2 - Cartão de Crédito");
        System.out.print("Escolha: ");
        int forma = Integer.parseInt(scanner.nextLine());

        Pagamento pagamento;
        if (forma == 1) {
            System.out.print("Código de barras do boleto: ");
            String codigo = scanner.nextLine();
            pagamento = new Boleto(codigo);
        } else {
            System.out.print("Número do cartão: ");
            String numeroCartao = scanner.nextLine();
            pagamento = new CartaoCredito(numeroCartao);
        }

        // Criar pedido
        Pedido pedido = new Pedido(1, itens, pagamento);
        cliente.adicionarPedido(pedido);

        // Calcular valor total
        double total = 0;
        for (ItemPedido item : itens) {
            total += item.getProduto().getPreco() * item.getQuantidade();
        }

        System.out.println("\n=== Processando Pagamento ===");
        pedido.processarPagamento();
        System.out.printf("Valor total pago: R$ %.2f\n", total);

        System.out.println("\n=== Resumo do Pedido ===");
        pedido.exibirResumo();

        scanner.close();
    }
}
