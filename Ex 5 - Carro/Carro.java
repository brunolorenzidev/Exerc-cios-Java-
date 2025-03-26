public class Carro {
    private final String marca;
    private final String modelo;
    private final int ano;
    private String placa;
    private double velocidadeAtual;


    public Carro(String marca, String modelo, int ano, String placa) {
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.placa = placa;
        this.velocidadeAtual = 0.0;
    }


    public void acelerar() {
        this.velocidadeAtual += 10.0;
        System.out.println("Acelerando! Velocidade atual: " + this.velocidadeAtual + " km/h");
    }


    public void frear() {
        if (this.velocidadeAtual >= 10.0) {
            this.velocidadeAtual -= 10.0;
            System.out.println("Freando! Velocidade atual: " + this.velocidadeAtual + " km/h");
        } else {
            this.velocidadeAtual = 0.0;
            System.out.println("Carro parado!");
        }
    }


    public void exibirInformacoes() {
        System.out.println("\nInformações do Carro:");
        System.out.println("Marca: " + this.marca);
        System.out.println("Modelo: " + this.modelo);
        System.out.println("Ano: " + this.ano);
        System.out.println("Placa: " + this.placa);
        System.out.println("Velocidade Atual: " + this.velocidadeAtual + " km/h");
    }

    
    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public String getPlaca() {
        return placa;
    }
}