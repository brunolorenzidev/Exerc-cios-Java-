import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<ContaBancaria> contas = new ArrayList<>();
        ContaBancaria contaAtual = null;
        
        while (true) {
            System.out.println("\n   Banco Dos Brunos ");
            System.out.println("1. Criar nova conta");
            System.out.println("2. Selecionar conta");
            System.out.println("3. Depositar");
            System.out.println("4. Sacar");
            System.out.println("5. Consultar saldo");
            System.out.println("6. Listar todas as contas");
            System.out.println("7. Sair");
            System.out.print("Escolha uma opção: ");
            
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer
            
            switch (opcao) {
                case 1:
                    System.out.print("Digite o número da conta: ");
                    String numeroConta = scanner.nextLine();
                    System.out.print("Digite o nome do titular: ");
                    String nomeTitular = scanner.nextLine();
                    ContaBancaria novaConta = new ContaBancaria(numeroConta, nomeTitular);
                    contas.add(novaConta);
                    System.out.println("Conta criada com sucesso!");
                    break;
                    
                case 2:
                    if (contas.isEmpty()) {
                        System.out.println("Não existem contas cadastradas!");
                        break;
                    }
                    System.out.println("\nContas disponíveis:");
                    for (int i = 0; i < contas.size(); i++) {
                        ContaBancaria c = contas.get(i);
                        System.out.printf("%d. Conta: %s - Titular: %s%n", 
                            i + 1, c.getNumeroConta(), c.getNomeTitular());
                    }
                    System.out.print("Escolha o número da conta: ");
                    int escolha = scanner.nextInt();
                    if (escolha > 0 && escolha <= contas.size()) {
                        contaAtual = contas.get(escolha - 1);
                        System.out.println("Conta selecionada com sucesso!");
                    } else {
                        System.out.println("Número de conta inválido!");
                    }
                    break;
                    
                case 3:
                    if (contaAtual != null) {
                        System.out.print("Digite o valor para depositar: R$ ");
                        double valorDeposito = scanner.nextDouble();
                        contaAtual.depositar(valorDeposito);
                    } else {
                        System.out.println("Por favor, selecione uma conta primeiro!");
                    }
                    break;
                    
                case 4:
                    if (contaAtual != null) {
                        System.out.print("Digite o valor para sacar: R$ ");
                        double valorSaque = scanner.nextDouble();
                        contaAtual.sacar(valorSaque);
                    } else {
                        System.out.println("Por favor, selecione uma conta primeiro!");
                    }
                    break;
                    
                case 5:
                    if (contaAtual != null) {
                        System.out.printf("Saldo atual da conta %s: R$ %.2f%n", 
                            contaAtual.getNumeroConta(), contaAtual.consultarSaldo());
                    } else {
                        System.out.println("Por favor, selecione uma conta primeiro!");
                    }
                    break;
                    
                case 6:
                    if (contas.isEmpty()) {
                        System.out.println("Não existem contas cadastradas!");
                        break;
                    }
                    System.out.println("\nLista de todas as contas:");
                    for (ContaBancaria c : contas) {
                        System.out.printf("Conta: %s - Titular: %s - Saldo: R$ %.2f%n", 
                            c.getNumeroConta(), c.getNomeTitular(), c.consultarSaldo());
                    }
                    break;
                    
                case 7:
                    System.out.println("Obrigado por usar nosso sistema bancário!");
                    scanner.close();
                    return;
                    
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        }
    }
} 