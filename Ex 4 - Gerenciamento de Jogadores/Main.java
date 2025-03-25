import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SistemaJogadores sistema = new SistemaJogadores();
        
        while (true) {
            System.out.println("\n BB  Gerenciamento de Jogadores  BB");
            System.out.println("1. Criar novo jogador");
            System.out.println("2. Listar todos os jogadores");
            System.out.println("3. Atualizar pontuação de um jogador");
            System.out.println("4. Buscar jogador");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer
            
            switch (opcao) {
                case 1:
                    System.out.print("Digite o nome do novo jogador: ");
                    String nome = scanner.nextLine();
                    sistema.adicionarJogador(nome);
                    break;
                    
                case 2:
                    sistema.listarJogadores();
                    break;
                    
                case 3:
                    System.out.print("Digite o nome do jogador: ");
                    String nomeJogador = scanner.nextLine();
                    System.out.print("Digite a quantidade de pontos a adicionar: ");
                    int pontos = scanner.nextInt();
                    
                    if (sistema.atualizarPontuacao(nomeJogador, pontos)) {
                        System.out.println("Pontuação atualizada com sucesso!");
                    } else {
                        System.out.println("Jogador não encontrado!");
                    }
                    break;
                    
                case 4:
                    System.out.print("Digite o nome do jogador: ");
                    String nomeBusca = scanner.nextLine();
                    Jogador jogadorEncontrado = sistema.buscarJogador(nomeBusca);
                    
                    if (jogadorEncontrado != null) {
                        jogadorEncontrado.exibirInformacoes();
                    } else {
                        System.out.println("Jogador não encontrado!");
                    }
                    break;
                    
                case 5:
                    System.out.println("Obrigado por usar o sistema!");
                    scanner.close();
                    return;
                    
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }
} 