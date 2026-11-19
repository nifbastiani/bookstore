package br.com.bookstore.model;

public class Livro {
    private Long id;
    private String titulo;
    private String autor;
    private double preco;

    //Construtor de Negócio: (String titulo, String autor, double preco) — atribui null ao id.
    public Livro(String titulo, String autor, double preco){
        this(null, titulo, autor, preco);
    }


    public Livro(Long id, String titulo, String autor, double preco) {
        if(titulo == null || titulo.trim().length() < 2){
            throw new IllegalArgumentException("O título deve ter pelo menos 2 caracteres");
        }
        if(autor == null || autor.trim().isEmpty()){
            throw new IllegalArgumentException("O autor não pode ser null ou vazio");
        }
        if(preco <= 0){
            throw new IllegalArgumentException("O preço deve ser estritamente positivo");
        }

        this.id = id;
        this.titulo = titulo.trim();
        this.autor = autor;
        this.preco = preco;
    }


    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }


    public String getTitulo() {
        return titulo;
    }


    public String getAutor() {
        return autor;
    }


    public double getPreco() {
        return preco;
    }


    @Override
    public String toString() {
        return "Livro [id = " + id + ", titulo = " + titulo + ", autor = " + autor + ", preço = R$" + preco + "]";
    }
    
    
}
