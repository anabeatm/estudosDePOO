package biblioteca.model;

public class Livro {
//    ATRIBUTOS
    private String titulo;
    private String autor;
    private String isbn;
    private Boolean isDisponivel;

//    GETTERS & SETTERS
    public void setTitulo(String titulo){this.titulo = titulo;}
    public String getTitulo(){return this.titulo;}

    public void setAutor(String autor){this.autor = autor;}
    public String getAutor(){return this.autor;}

    public void setIsbn(String isbn){this.isbn = isbn;}
    public String getIsbn(){return this.isbn;}

    public void setIsDisponivel(Boolean isDisponivel){this.isDisponivel = isDisponivel;}
    public Boolean isDisponivel(){return this.isDisponivel;}

//    CONSTRUTORES
    public Livro(){}

    public Livro(String titulo, String autor, String isbn) {
        this.setTitulo(titulo);
        this.setAutor(autor);
        this.setIsbn(isbn);
        this.setIsDisponivel(true);
    }

    public Livro(String titulo, String autor) {
        this.setTitulo(titulo);
        this.setAutor(autor);
        this.setIsDisponivel(true);
    }

//    MÉTODOS
    public void getDetalhesLivro() {
        if(this.titulo.isBlank() | this.autor.isBlank()) {
            System.out.println("Impossível gerar resumo.");
        } else {
            System.out.printf("""
                    Título: %s
                    Autor: %s
                    ISBN: %s
                    Disponibilidade: %s
                    """, getTitulo(), getAutor(), getIsbn(), isDisponivel()
            );
        }
    }
}
