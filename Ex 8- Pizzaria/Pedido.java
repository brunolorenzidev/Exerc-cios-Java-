import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Pedido {
    private static List<Pedido> todosPedidos = new ArrayList<>();
    
    private Pizza pizza;
    private String tamanho;
    private String enderecoEntrega;
    private boolean cancelado;
    private double valorTotal;
    private int quantidade;
    private int grupoPedido;

    public Pedido(Pizza pizza, String tamanho, String enderecoEntrega, int quantidade, int grupoPedido) {
        this.pizza = pizza;
        this.tamanho = tamanho;
        this.enderecoEntrega = enderecoEntrega;
        this.cancelado = false;
        this.quantidade = quantidade;
        this.grupoPedido = grupoPedido;
        this.valorTotal = calcularValorTotal();
        todosPedidos.add(this);
    }

    private double calcularValorTotal() {
        double valorBase = pizza.getValor();
        double multiplicadorTamanho = switch (tamanho.toLowerCase()) {
            case "media" -> 1.5;
            case "grande" -> 2.0;
            default -> 1.0;
        };
        return valorBase * multiplicadorTamanho * quantidade;
    }

    public void cancelar() {
        this.cancelado = true;
    }

    public static List<Pedido> getTodosPedidos() {
        return todosPedidos;
    }

    public static int getTotalPedidos() {
        return todosPedidos.stream()
                .mapToInt(Pedido::getGrupoPedido)
                .distinct()
                .toArray().length;
    }

    public static double getMediaPrecoPedidos() {
        if (todosPedidos.isEmpty()) return 0;
        
        List<Double> totaisGrupos = todosPedidos.stream()
                .filter(p -> !p.isCancelado())
                .collect(Collectors.groupingBy(Pedido::getGrupoPedido))
                .values()
                .stream()
                .map(grupo -> grupo.stream().mapToDouble(Pedido::getValorTotal).sum())
                .collect(Collectors.toList());
        
        if (totaisGrupos.isEmpty()) return 0;
        
        return totaisGrupos.stream().mapToDouble(Double::doubleValue).average().orElse(0);
    }

    public static String gerarRelatorio() {
        StringBuilder sb = new StringBuilder();
        sb.append(" RELATÓRIO DE PEDIDOS \n");
        sb.append("Total de pedidos: ").append(getTotalPedidos()).append("\n");
        sb.append("Média de preço: R$").append(String.format("%.2f", getMediaPrecoPedidos())).append("\n\n");
        
        sb.append("Detalhes dos pedidos:\n");
        
        todosPedidos.stream()
                .collect(Collectors.groupingBy(Pedido::getGrupoPedido))
                .forEach((grupo, pedidos) -> {
                    sb.append(" PEDIDO #").append(grupo).append(" ===\n");
                    sb.append("Endereço de entrega: ").append(pedidos.get(0).getEnderecoEntrega()).append("\n");
                    sb.append("Status: ").append(pedidos.get(0).isCancelado() ? "Cancelado" : "Ativo").append("\n");
                    sb.append("\nItens do pedido:\n");
                    
                    double totalGrupo = 0;
                    for (Pedido pedido : pedidos) {
                        sb.append("- ").append(pedido.getPizza().getNome())
                          .append(" (").append(pedido.getTamanho())
                          .append(") x").append(pedido.getQuantidade())
                          .append(" - R$").append(String.format("%.2f", pedido.getValorTotal()))
                          .append("\n");
                        totalGrupo += pedido.getValorTotal();
                    }
                    
                    sb.append("\nTotal do pedido: R$").append(String.format("%.2f", totalGrupo)).append("\n");
                    sb.append("------------------------\n");
                });
        
        return sb.toString();
    }

    // Getters e Setters
    public boolean isCancelado() {
        return cancelado;
    }

    public int getGrupoPedido() {
        return grupoPedido;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public String getEnderecoEntrega() {
        return enderecoEntrega;
    }

    public Pizza getPizza() {
        return pizza;
    }

    public String getTamanho() {
        return tamanho;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setEnderecoEntrega(String enderecoEntrega) {
        this.enderecoEntrega = enderecoEntrega;
    }
} 