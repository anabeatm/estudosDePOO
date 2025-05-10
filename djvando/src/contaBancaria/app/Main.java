package contaBancaria.app;
import contaBancaria.model.ContaBanco;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        ContaBanco conta = new ContaBanco();
        Main imprimir = new Main();
        imprimir.imprimindoConta(in, conta);
    }

    public void imprimindoConta(Scanner in, ContaBanco conta) {
        int entrada;

        do {
            System.out.println("--> Sua conta bancária!");
            System.out.println("""
                    [1] Abrir Conta
                    [2] Fechar Conta
                    [3] Depositar
                    [4] Sacar
                    [5] Pagar Mensalidade
                    [6] Visualizar Conta Bancária
                    [7] Número da Conta
                    [0] Sair""");
            System.out.println("------------------------------------------");
            System.out.print("Opção: ");

            entrada = in.nextInt();
            in.nextLine();

            if (entrada == 1) {
                System.out.println("Que tipo de conta será? [CC] para conta corrente e [CP] para conta poupança: ");
                String tipoConta = in.nextLine().toLowerCase();
                conta.abrirConta(tipoConta);
                System.out.println("Status da conta: " + conta.getStatus() + " | Tipo da conta: " + conta.getTipo()
                        + " | Saldo: R$" + conta.getSaldo() + " | Número da Conta: " + conta.getNumConta());

            } else if (entrada == 2) {
                System.out.print("Valor a ser sacado: R$");
                float valorSerSacado = in.nextFloat();
                conta.fecharConta(valorSerSacado);

            } else if (entrada == 3) {
                System.out.print("Valor a ser depositado: R$");
                float valorDepositar = in.nextFloat();
                conta.depositar(valorDepositar);

            } else if (entrada == 4) {
                System.out.print("Valor a ser sacado: R$");
                float valorSerSacado = in.nextFloat();
                conta.sacar(valorSerSacado);

            } else if (entrada == 5) {
                conta.pagarMensal();

            } else if (entrada == 6) {
                conta.visualizarContaBancaria();

            } else if (entrada == 7) {
                conta.exibirNumConta();
            }

        } while (entrada > 0);
    }
}
