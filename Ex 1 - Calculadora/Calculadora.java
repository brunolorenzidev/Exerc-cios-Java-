public class Calculadora {
    // Método para adição
    public static double adicionar(double a, double b) {
        return a + b;
    }

    // Método para subtração
    public static double subtrair(double a, double b) {
        return a - b;
    }

    // Método para multiplicação
    public static double multiplicar(double a, double b) {
        return a * b;
    }

    // Método para divisão com tratamento de divisão por zero
    public static double dividir(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("Não é possível dividir por zero!");
        }
        return a / b;
    }
}