import java.util.ArrayList;
import java.util.List;

public class SistemaJogadores {
    private List<Jogador> jogadores;

    public SistemaJogadores() {
        this.jogadores = new ArrayList<>();
    }

    public void adicionarJogador(String nome) {
        Jogador novoJogador = new Jogador(nome);
        jogadores.add(novoJogador);
        System.out.println("Jogador " + nome + " adicionado com sucesso!");
    }

    public Jogador buscarJogador(String nome) {
        for (Jogador jogador : jogadores) {
            if (jogador.getNome().equalsIgnoreCase(nome)) {
                return jogador;
            }
        }
        return null;
    }

    public void listarJogadores() {
        if (jogadores.isEmpty()) {
            System.out.println("Não há jogadores cadastrados.");
            return;
        }
        
        System.out.println("\n BB  Lista de Jogadores  BB ");
        for (Jogador jogador : jogadores) {
            jogador.exibirInformacoes();
        }
    }

    public boolean atualizarPontuacao(String nome, int pontos) {
        Jogador jogador = buscarJogador(nome);
        if (jogador != null) {
            jogador.aumentarPontuacao(pontos);
            return true;
        }
        return false;
    }
} 