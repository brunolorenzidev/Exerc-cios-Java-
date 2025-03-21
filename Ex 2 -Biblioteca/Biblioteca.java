import java.util.Scanner;
import java.util.ArrayList;

public class Biblioteca {
    private ArrayList<Livro> livros;
    private Scanner scanner;

    public Biblioteca() {
        livros = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void adicionarLivro() {
        System.out.println("\n = Cadastro de Novo Livro =");
        
        System.out.print("Digite o título do livro: ");
        String titulo = scanner.nextLine();
        
        System.out.print("Digite o nome do autor: ");
        String autor = scanner.nextLine();
        
        System.out.print("Digite o ano de publicação: ");
        int ano = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer

        Livro novoLivro = new Livro(titulo, autor, ano);
        livros.add(novoLivro);
        System.out.println("\nLivro cadastrado com sucesso!");
    }

    public void exibirTodosLivros() {
        if (livros.isEmpty()) {
            System.out.println("\nNenhum livro cadastrado na biblioteca!");
            return;
        }

        System.out.println("\n Biblioteca dos Brunos ");
        System.out.println("==============================\n");
        
        for (Livro livro : livros) {
            livro.exibirInfo();
        }
    }

    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();
        int opcao;

        do {
            System.out.println("\n Menu da Biblioteca dos Brunos ");
            System.out.println("1. Cadastrar novo livro");
            System.out.println("2. Exibir todos os livros");
            System.out.println("3. Sair");
            System.out.print("\nEscolha uma opção: ");
            
            opcao = biblioteca.scanner.nextInt();
            biblioteca.scanner.nextLine(); // Limpar o buffer

            switch (opcao) {
                case 1:
                    biblioteca.adicionarLivro();
                    break;
                case 2:
                    biblioteca.exibirTodosLivros();
                    break;
                case 3:
                    System.out.println("\nObrigado por usar a Biblioteca!");
                    break;
                default:
                    System.out.println("\nOpção inválida! Tente novamente.");
            }
        } while (opcao != 3);
    }
} 