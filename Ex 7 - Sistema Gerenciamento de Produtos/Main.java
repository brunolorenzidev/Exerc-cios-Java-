import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static List<Produto> estoque = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcao;
        do {
            exibirMenu();
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer

            switch (opcao) {
                case 1:
                    adicionarProduto();
                    break;
                case 2:
                    atualizarProduto();
                    break;
                case 3:
                    removerProduto();
                    break;
                case 4:
                    exibirEstoque();
                    break;
                case 5:
                    gerarRelatorio();
                    break;
                case 0:
                    System.out.println("Saindo do sistema...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
    }

    private static void exibirMenu() {
        System.out.println("\n BB   Sistema de Gerenciamento de Produtos   BB");
        System.out.println("1. Adicionar novo produto");
        System.out.println("2. Atualizar produto existente");
        System.out.println("3. Remover produto");
        System.out.println("4. Exibir estoque");
        System.out.println("5. Gerar relatório");
        System.out.println("0. Sair");
        System.out.print("Escolha uma opção: ");
    }

    private static void adicionarProduto() {
        System.out.println("\n BB  Adicionar Novo Produto   BB");
        System.out.print("Nome do produto: ");
        String nome = scanner.nextLine();
        System.out.print("Código do produto: ");
        String codigo = scanner.nextLine();
        System.out.print("Preço do produto: ");
        double preco = scanner.nextDouble();
        System.out.print("Quantidade em estoque: ");
        int quantidade = scanner.nextInt();

        Produto produto = new Produto(nome, codigo, preco, quantidade);
        estoque.add(produto);
        System.out.println("Produto adicionado com sucesso!");
    }

    private static void atualizarProduto() {
        System.out.println("\n BB  Atualizar Produto  BB");
        System.out.print("Digite o código do produto: ");
        String codigo = scanner.nextLine();

        Produto produto = buscarProdutoPorCodigo(codigo);
        if (produto != null) {
            System.out.print("Novo nome (ou pressione Enter para manter): ");
            String nome = scanner.nextLine();
            if (!nome.isEmpty()) {
                produto.setNome(nome);
            }
            System.out.print("Novo preço (ou 0 para manter): ");
            double preco = scanner.nextDouble();
            if (preco > 0) {
                produto.setPreco(preco);
            }
            System.out.print("Nova quantidade (ou -1 para manter): ");
            int quantidade = scanner.nextInt();
            if (quantidade >= 0) {
                produto.setQuantidadeEstoque(quantidade);
            }
            System.out.println("Produto atualizado com sucesso!");
        } else {
            System.out.println("Produto não encontrado!");
        }
    }

    private static void removerProduto() {
        System.out.println("\n  BB  Remover Produto   BB");
        System.out.print("Digite o código do produto: ");
        String codigo = scanner.nextLine();

        Produto produto = buscarProdutoPorCodigo(codigo);
        if (produto != null) {
            estoque.remove(produto);
            System.out.println("Produto removido com sucesso!");
        } else {
            System.out.println("Produto não encontrado!");
        }
    }

    private static void exibirEstoque() {
        System.out.println("\n BB   Estoque Atual   BB ");
        if (estoque.isEmpty()) {
            System.out.println("Estoque vazio!");
        } else {
            for (Produto produto : estoque) {
                System.out.println(produto);
            }
        }
    }

    private static void gerarRelatorio() {
        System.out.println("\n BB   Relatório de Estoque   BB ");
        if (estoque.isEmpty()) {
            System.out.println("Estoque vazio!");
        } else {
            double valorTotal = 0;
            System.out.println("Produtos disponíveis:");
            for (Produto produto : estoque) {
                System.out.println(produto);
                valorTotal += produto.getPreco() * produto.getQuantidadeEstoque();
            }
            System.out.printf("Valor total em estoque: R$ %.2f%n", valorTotal);
        }
    }

    private static Produto buscarProdutoPorCodigo(String codigo) {
        for (Produto produto : estoque) {
            if (produto.getCodigo().equals(codigo)) {
                return produto;
            }
        }
        return null;
    }
} 