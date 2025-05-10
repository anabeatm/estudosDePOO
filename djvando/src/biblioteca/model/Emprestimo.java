package biblioteca.model;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Emprestimo {
    private LocalDate dataEmprestimo;
    private LocalDate dataDevolucao;
    private Livro livro;
    private Usuario usuario;

    //    private LocalDate hoje = LocalDate.now();

    public void setDataEmprestimo(LocalDate dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }
    public LocalDate getDataEmprestimo() {
        return dataEmprestimo;
    }

    public void setDataDevolucao(LocalDate dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }
    public LocalDate getDataDevolucao() {
        return dataDevolucao;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }
    public Livro getLivro() {
        return livro;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    public Usuario getUsuario() {
        return usuario;
    }

    public Boolean estaAtrasado() {
        return LocalDate.now().isAfter(dataDevolucao);
    }

    public Double calcularMulta() {
        double multaDiaria = 2.50;

        if(!estaAtrasado()) { // se estaAtrasado for true, !true = false, return 0.0
            return 0.0;
        } else {
            // calcula a diferença de dias entre uma data e outra,
            // porém só se dataDevolucao for < que hoje
            long diasAtrasoMulta = ChronoUnit.DAYS.between(dataDevolucao, LocalDate.now());
            return diasAtrasoMulta * multaDiaria;
        }
    }

//    TODO: Criar um método que altere a disponibilidade do Livro para true quando devolvido
    public Boolean finalizarEmprestimo() {
        this.livro.setIsDisponivel(true);
        return this.livro.isDisponivel();
    }
}
