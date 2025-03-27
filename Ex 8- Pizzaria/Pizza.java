public class Pizza {
    private String nome;
    private double valor;
    private String[] ingredientes;

    public Pizza(String nome, double valor, String[] ingredientes) {
        this.nome = nome;
        this.valor = valor;
        this.ingredientes = ingredientes;
    }

    public String getNome() {
        return nome;
    }

    public double getValor() {
        return valor;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(nome).append(" - R$").append(String.format("%.2f", valor)).append("\n");
        sb.append("Ingredientes: ");
        for (int i = 0; i < ingredientes.length; i++) {
            sb.append(ingredientes[i]);
            if (i < ingredientes.length - 1) {
                sb.append(", ");
            }
        }
        return sb.toString();
    }
} 