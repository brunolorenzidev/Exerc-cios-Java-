public class Jogador {
    private String nome;
    private int pontuacao;
    private int nivel;


    public Jogador(String nome) {
        this.nome = nome;
        this.pontuacao = 0;
        this.nivel = 1;
    }


    public String getNome() {
        return nome;
    }

    public int getPontuacao() {
        return pontuacao;
    }

    public int getNivel() {
        return nivel;
    }


    public void aumentarPontuacao(int pontos) {
        if (pontos > 0) {
            this.pontuacao += pontos;
            verificarNivel();
        }
    }


    private void verificarNivel() {

        int novoNivel = (this.pontuacao / 100) + 1;
        if (novoNivel > this.nivel) {
            this.nivel = novoNivel;
            System.out.println("Parabéns! Você subiu para o nível " + this.nivel + "!");
        }
    }


    public void exibirInformacoes() {
        System.out.println(" BB  Informações do Jogador  BB ");
        System.out.println("Nome: " + this.nome);
        System.out.println("Pontuação: " + this.pontuacao);
        System.out.println("Nível: " + this.nivel);
        System.out.println("===========================");
    }
} 