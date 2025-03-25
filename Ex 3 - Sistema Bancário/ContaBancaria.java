public class ContaBancaria {
    private String numeroConta;
    private String nomeTitular;
    private double saldo;

    // Construtor
    public ContaBancaria(String numeroConta, String nomeTitular) {
        this.numeroConta = numeroConta;
        this.nomeTitular = nomeTitular;
        this.saldo = 0.0;
    }

    // Método para depositar dinheiro
    public void depositar(double valor) {
        if (valor > 0) {
            this.saldo += valor;
            System.out.printf("Depósito de R$ %.2f realizado com sucesso!%n", valor);
        } else {
            System.out.println("Erro: O valor do depósito deve ser maior que zero.");
        }
    }

    // Método para sacar dinheiro
    public void sacar(double valor) {
        if (valor > 0) {
            if (valor <= this.saldo) {
                this.saldo -= valor;
                System.out.printf("Saque de R$ %.2f realizado com sucesso!%n", valor);
            } else {
                System.out.println("Erro: Saldo insuficiente para realizar o saque.");
            }
        } else {
            System.out.println("Erro: O valor do saque deve ser maior que zero.");
        }
    }

    // Método para consultar o saldo
    public double consultarSaldo() {
        return this.saldo;
    }

    // Getters e Setters
    public String getNumeroConta() {
        return numeroConta;
    }

    public String getNomeTitular() {
        return nomeTitular;
    }

    public void setNomeTitular(String nomeTitular) {
        this.nomeTitular = nomeTitular;
    }
} 