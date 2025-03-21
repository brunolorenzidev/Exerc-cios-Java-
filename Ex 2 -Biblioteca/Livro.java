public class Livro {
    private String titulo;
    private String autor;
    private int ano;

    // Construtor
    public Livro(String titulo, String autor, int ano) {
        this.titulo = titulo;
        this.autor = autor;
        this.ano = ano;
    }

    // Método para exibir informações do livro
    public void exibirInfo() {
        System.out.println("Informações do Livro:");
        System.out.println("Título: " + titulo);
        System.out.println("Autor: " + autor);
        System.out.println("Ano de publicação: " + ano);
        System.out.println("------------------------");
    }
} 