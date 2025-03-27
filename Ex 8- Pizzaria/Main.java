import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Pizza> menuPizzas = new ArrayList<>();
        
        menuPizzas.add(new Pizza("Margherita", 35.00, 
            new String[]{"Molho de tomate", "Mussarela", "Manjericão"}));
        menuPizzas.add(new Pizza("Calabresa", 40.00, 
            new String[]{"Molho de tomate", "Mussarela", "Calabresa", "Cebola"}));
        menuPizzas.add(new Pizza("Portuguesa", 45.00, 
            new String[]{"Molho de tomate", "Mussarela", "Presunto", "Cebola", "Tomate", "Azeitonas"}));
        menuPizzas.add(new Pizza("Frango com Catupiry", 42.00, 
            new String[]{"Molho de tomate", "Mussarela", "Frango desfiado", "Catupiry"}));
        menuPizzas.add(new Pizza("Quatro Queijos", 48.00, 
            new String[]{"Molho de tomate", "Mussarela", "Provolone", "Parmesão", "Gorgonzola"}));
        menuPizzas.add(new Pizza("Pepperoni", 46.00, 
            new String[]{"Molho de tomate", "Mussarela", "Pepperoni", "Cebola"}));
        menuPizzas.add(new Pizza("Chocolate com Morango", 52.00, 
            new String[]{"Chocolate", "Morango", "Chantilly"}));
        menuPizzas.add(new Pizza("Romeu e Julieta", 50.00, 
            new String[]{"Goiabada", "Queijo Minas", "Nozes"}));

        while (true) {
            System.out.println("\n SISTEMA DE PEDIDOS DE PIZZA ");
            System.out.println("1. Ver cardápio");
            System.out.println("2. Fazer pedido");
            System.out.println("3. Cancelar pedido");
            System.out.println("4. Ver relatório de pedidos");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println("\n CARDÁPIO ");
                    for (int i = 0; i < menuPizzas.size(); i++) {
                        System.out.println((i + 1) + ". " + menuPizzas.get(i));
                    }
                    break;

                case 2:
                    System.out.println("\n FAZER PEDIDO ");
                    List<Pedido> pizzasDoPedido = new ArrayList<>();
                    int grupoPedido = Pedido.getTotalPedidos() + 1;
                    
                    do {
                        System.out.println("\nEscolha a pizza (1-" + menuPizzas.size() + "): ");
                        int escolhaPizza = scanner.nextInt() - 1;
                        scanner.nextLine();

                        if (escolhaPizza >= 0 && escolhaPizza < menuPizzas.size()) {
                            System.out.println("\nTamanhos disponíveis:");
                            System.out.println("1. Pequena (preço base)");
                            System.out.println("2. Média (1.5x preço base)");
                            System.out.println("3. Grande (2x preço base)");
                            System.out.print("Escolha o tamanho (1-3): ");
                            
                            int escolhaTamanho = scanner.nextInt();
                            String tamanho;
                            switch (escolhaTamanho) {
                                case 1:
                                    tamanho = "pequena";
                                    break;
                                case 2:
                                    tamanho = "media";
                                    break;
                                case 3:
                                    tamanho = "grande";
                                    break;
                                default:
                                    System.out.println("Tamanho inválido! Usando tamanho pequena.");
                                    tamanho = "pequena";
                            }

                            scanner.nextLine();
                            System.out.print("Digite a quantidade: ");
                            int quantidade = scanner.nextInt();
                            scanner.nextLine();

                            pizzasDoPedido.add(new Pedido(menuPizzas.get(escolhaPizza), tamanho, "", quantidade, grupoPedido));
                            System.out.println("Pizza adicionada ao pedido com sucesso!");
                            
                            System.out.print("\nDeseja adicionar mais pizzas? (s/n): ");
                            String continuar = scanner.nextLine().toLowerCase();
                            if (!continuar.equals("s")) {
                                break;
                            }
                        } else {
                            System.out.println("Opção inválida!");
                            scanner.nextLine();
                        }
                    } while (true);

                    if (!pizzasDoPedido.isEmpty()) {
                        System.out.println("\n RESUMO DO PEDIDO ");
                        System.out.println("Total de pizzas no pedido: " + pizzasDoPedido.size());


                        double totalPedido = pizzasDoPedido.stream()
                                .mapToDouble(Pedido::getValorTotal)
                                .sum();
                        System.out.printf("Total do pedido: R$%.2f%n", totalPedido);

                        String endereco;
                        do {
                            System.out.println("\nDigite o endereço de entrega (obrigatório): ");
                            endereco = scanner.nextLine().trim();

                            if (endereco.isEmpty()) {
                                System.out.println("Erro: O endereço não pode estar vazio!");
                            }
                        } while (endereco.isEmpty());


                        for (Pedido pedido : pizzasDoPedido) {
                            pedido.setEnderecoEntrega(endereco);
                        }

                        System.out.println("\nPedido finalizado com sucesso!");
                    }
                    break;

                case 3:
                    System.out.println("\n CANCELAR PEDIDO ");
                    System.out.println("Digite o número do pedido para cancelar: ");
                    int numeroPedido = scanner.nextInt();
                    
                    List<Pedido> pedidosParaCancelar = Pedido.getTodosPedidos().stream()
                            .filter(p -> p.getGrupoPedido() == numeroPedido && !p.isCancelado())
                            .collect(Collectors.toList());
                    
                    if (!pedidosParaCancelar.isEmpty()) {
                        pedidosParaCancelar.forEach(Pedido::cancelar);
                        System.out.println("Pedido cancelado com sucesso!");
                    } else {
                        System.out.println("Pedido não encontrado ou já cancelado!");
                    }
                    break;

                case 4:
                    System.out.println(Pedido.gerarRelatorio());
                    break;

                case 5:
                    System.out.println("Obrigado por usar nosso sistema!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Opção inválida!");
            }
        }
    }
}