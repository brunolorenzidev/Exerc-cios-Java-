import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;

        while (continuar) {
            System.out.println("\n= Calculadora Dos Brunos =");
            System.out.println("1. Adição");
            System.out.println("2. Subtração");
            System.out.println("3. Multiplicação");
            System.out.println("4. Divisão");
            System.out.println("5. Sair");

            System.out.print("\nEscolha a operação (1-5): ");
            int opcao = scanner.nextInt();

            if (opcao == 5) {
                continuar = false;
                System.out.println("Obrigado por usar a calculadora!");
                break;
            }

            if (opcao < 1 || opcao > 5) {
                System.out.println("Opção inválida! Tente novamente.");
                continue;
            }

            System.out.print("Digite o primeiro número: ");
            double num1 = scanner.nextDouble();

            System.out.print("Digite o segundo número: ");
            double num2 = scanner.nextDouble();

            double resultado = 0;
            String operacao = "";

            try {
                switch (opcao) {
                    case 1:
                        resultado = Calculadora.adicionar(num1, num2);
                        operacao = "+";
                        break;
                    case 2:
                        resultado = Calculadora.subtrair(num1, num2);
                        operacao = "-";
                        break;
                    case 3:
                        resultado = Calculadora.multiplicar(num1, num2);
                        operacao = "×";
                        break;
                    case 4:
                        resultado = Calculadora.dividir(num1, num2);
                        operacao = "÷";
                        break;
                }

                System.out.printf("\nResultado: %.2f %s %.2f = %.2f\n",
                        num1, operacao, num2, resultado);

            } catch (ArithmeticException e) {
                System.out.println("\nErro: " + e.getMessage());
            }

            System.out.println("\n------------------------");
        }

        scanner.close();
    }
}