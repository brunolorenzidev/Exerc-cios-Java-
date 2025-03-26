import java.util.ArrayList;
import java.util.List;

public class Agenda {
    private List<Contato> contatos;

    public Agenda() {
        this.contatos = new ArrayList<>();
    }

    public void adicionarContato(Contato contato) {
        contatos.add(contato);
    }

    public void removerContato(String nome) {
        contatos.removeIf(contato -> contato.getNome().equalsIgnoreCase(nome));
    }

    public Contato buscarContato(String nome) {
        return contatos.stream()
                .filter(contato -> contato.getNome().equalsIgnoreCase(nome))
                .findFirst()
                .orElse(null);
    }

    public List<Contato> listarContatos() {
        return new ArrayList<>(contatos);
    }

    public boolean contatoExiste(String nome) {
        return contatos.stream()
                .anyMatch(contato -> contato.getNome().equalsIgnoreCase(nome));
    }
} 