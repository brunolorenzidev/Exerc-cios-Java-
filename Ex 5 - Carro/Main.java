import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Carro> carros = new ArrayList<>();
        
        while (true) {
            System.out.println("\n Menu Principal ");
            System.out.println("1. Cadastrar novo carro");
            System.out.println("2. Listar todos os carros");
            System.out.println("3. Controlar um carro");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");
            
            int opcao = scanner.nextInt();
            scanner.nextLine();
            
            switch (opcao) {
                case 1:
                    cadastrarCarro(scanner, carros);
                    break;
                case 2:
                    listarCarros(carros);
                    break;
                case 3:
                    controlarCarro(scanner, carros);
                    break;
                case 4:
                    System.out.println("Programa encerrado!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        }
    }
    
    private static void cadastrarCarro(Scanner scanner, ArrayList<Carro> carros) {
        System.out.println("\n Cadastro do Carro ");
        System.out.print("Digite a marca do carro: ");
        String marca = scanner.nextLine();
        
        System.out.print("Digite o modelo do carro: ");
        String modelo = scanner.nextLine();
        
        System.out.print("Digite o ano do carro: ");
        int ano = scanner.nextInt();
        scanner.nextLine();
        
        System.out.print("Digite a placa do carro: ");
        String placa = scanner.nextLine();
        
        Carro novoCarro = new Carro(marca, modelo, ano, placa);
        carros.add(novoCarro);
        System.out.println("\nCarro cadastrado com sucesso!");
    }
    
    private static void listarCarros(ArrayList<Carro> carros) {
        if (carros.isEmpty()) {
            System.out.println("\n Nenhum carro cadastrado!");
            return;
        }
        
        System.out.println("\n Lista de Carros Cadastrados ");
        for (int i = 0; i < carros.size(); i++) {
            System.out.println("\n Carro " + (i + 1) + ":");
            carros.get(i).exibirInformacoes();
        }
    }
    
    private static void controlarCarro(Scanner scanner, ArrayList<Carro> carros) {
        if (carros.isEmpty()) {
            System.out.println("\nNenhum carro cadastrado! Cadastre um carro primeiro.");
            return;
        }
        
        System.out.println("\n Seleção de Carro ");
        for (int i = 0; i < carros.size(); i++) {
            System.out.println((i + 1) + ". " + carros.get(i).getMarca() + " " + 
                             carros.get(i).getModelo() + " - Placa: " + 
                             carros.get(i).getPlaca());
        }
        
        System.out.print("\nEscolha o número do carro para controlar: ");
        int escolha = scanner.nextInt();
        
        if (escolha < 1 || escolha > carros.size()) {
            System.out.println("Opção inválida!");
            return;
        }
        
        Carro carroSelecionado = carros.get(escolha - 1);
        
        while (true) {
            System.out.println("\n Controle do Carro: " + carroSelecionado.getMarca() +
                             " " + carroSelecionado.getModelo() + " ");
            System.out.println("1. Acelerar");
            System.out.println("2. Frear");
            System.out.println("3. Exibir Informações");
            System.out.println("4. Voltar ao menu principal");
            System.out.print("Escolha uma opção: ");
            
            int opcao = scanner.nextInt();
            
            switch (opcao) {
                case 1:
                    carroSelecionado.acelerar();
                    break;
                case 2:
                    carroSelecionado.frear();
                    break;
                case 3:
                    carroSelecionado.exibirInformacoes();
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        }
    }
}
