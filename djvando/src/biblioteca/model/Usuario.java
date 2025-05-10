package biblioteca.model;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
    private String nome;
    private int id;

    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getNome() {
        return nome;
    }

    public void setId(int id) {
        this.id = id;
    }
    public Integer getId() {
        return id;
    }

    public Usuario(){}

    public Usuario(String nome) {this.setNome(nome);}

    public Usuario(String nome, Integer id) {
        this.setNome(nome);
        this.setId(id);
    }

//    TODO: Implementar listagem de empréstimo
    public List<Emprestimo> listarEmprestimo() {

    }
//    TODO: Implementar se há empréstimos pendentes
    public Boolean temEmprestimosPendentes() {return true;}
}
