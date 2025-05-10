package biblioteca.model;

import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    private String nomeBiblioteca;
    private ArrayList<Livro> livros = new ArrayList<>();
    private ArrayList<Usuario> usuarios = new ArrayList<>();
    private ArrayList<Emprestimo> emprestimos = new ArrayList<>();

//    TODO: Adicionar getters e setters
    public void setNomeBiblioteca(String nomeBiblioteca) {this.nomeBiblioteca = nomeBiblioteca;}
    public String getNomeBiblioteca() {return nomeBiblioteca;}

    public void setLivros(ArrayList<Livro> livros) {this.livros = livros;}
    public ArrayList<Livro> getLivros() {
        return livros;
    }

    public void setUsuarios(ArrayList<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setEmprestimos(ArrayList<Emprestimo> emprestimos) {
        this.emprestimos = emprestimos;
    }
    public ArrayList<Emprestimo> getEmprestimos() {
        return emprestimos;
    }

    public Biblioteca() {}

    public Biblioteca(String nomeBiblioteca) {
        this.setNomeBiblioteca(nomeBiblioteca);
    }

//    TODO: Implementar métodos
    public void adicionarLivro(Livro livro) {}
    public void removerLivro(String isbn) {}

    public void registrarUsuario(Usuario usuario) {}
    public void removerUsuario(int id) {}

    public List<Livro> buscarLivroTitulo(String titulo) {}
    public List<Livro> buscarLivroAutor(String autor) {}

    public Emprestimo realizarEmprestimo(Livro livro, Usuario usuario) {}
    public void registrarDevolucao(Emprestimo emprestimo) {}
    public List<Emprestimo> listarEmprestimosAtivos() {}
}
