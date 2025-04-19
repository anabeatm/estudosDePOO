import java.util.Scanner;
import java.util.Random;

public class ContaBanco {
    private String numConta;
    protected String tipo;
    private float saldo;
    private boolean status;

    Scanner in = new Scanner(System.in);

    public void setNumConta(String numeroConta) {
        numConta = numeroConta;
    }
    public String getNumConta() {
        return this.numConta;
    }

    public void setTipo(String t) {
        tipo = t;
    }
    public String getTipo() {
        return this.tipo;
    }

    public void setSaldo(float s) {
        saldo = s;
    }
    public float getSaldo() {
        return this.saldo;
    }

    public void setStatus(boolean st) {
        status = st;
    }
    public boolean getStatus() {
        return this.status;
    }

    public ContaBanco() {
        this.setStatus(false);
        saldo = 0.0f;
        gerarNumeroDaConta();
    }

    public void abrirConta(String tipoConta) {
        this.status = true;
        this.setTipo(tipoConta);
        if(tipoConta.equals("cc")) {
            this.setSaldo(50f);
        } else if (tipoConta.equals("cp")) {
            saldo = 150f;
            this.setSaldo(150f);
        } else {
            System.out.println("Ação Inválida!");
        }
    }

    public void sacar() {
        if(this.status) {
            System.out.println("Total: " + this.saldo);
            System.out.print("Valor a ser sacado: R$ ");
            float valorSerSacado = in.nextFloat();
            if (valorSerSacado > this.saldo) {
                System.out.println("Valor impossível de sacar.");
            } else {
                this.saldo -= valorSerSacado;
                this.setSaldo(saldo);
                System.out.println("Valor sacado!");
            }
        } else{
            System.out.println("Impossível sacar.");
        }
    }

    public void fecharConta() {
        this.sacar();
        if(this.saldo > 0) {
            System.out.println("Impossível de fechar a conta!");
        } else {
            this.status = false;
            System.out.println("Conta fechada!");
        }
    }

    public void depositar() {
        if(this.status) {
            System.out.println("Total: " + this.saldo);
            System.out.print("Valor a ser depositado: R$ ");
            float valorDepositar = in.nextFloat();
            if(valorDepositar < 0) {
                System.out.println("Valor impossível de depositar.");
            } else {
                saldo += valorDepositar;
                this.setSaldo(saldo);
                System.out.println("Valor depositado!");
            }
        } else {
            System.out.println("Impossível depositar.");
        }
    }

    public void pagarMensal() {
        if(this.status == true) {
            if(this.getTipo().equals("cc")) {
                saldo -= 12f;
                System.out.println("Valor de R$12 a.m pago!");
                this.setSaldo(saldo);
                System.out.println("Valor total: " + getSaldo());
            } else if (this.getTipo().equals("cp")) {
                saldo -= 20f;
                System.out.println("Valor de R$20 a.m pago!");
                this.setSaldo(saldo);
                System.out.println("Valor total: " + getSaldo());
            }
        } else {
            System.out.println("Acesso negado.");
        }
    }

    public void visualizarContaBancaria() {
        System.out.printf("""
                Tipo: %s
                Saldo: R$%s
                Status: %s\n""", getTipo(), getSaldo(), getStatus());
    }

    public void gerarNumeroDaConta() {
        Random random = new Random();
        int[] numeroDaConta = new int[7];
        for (int i = 0; i < 7; i++) {
            numeroDaConta[i] = random.nextInt(10);
        }
        String numContaFormatada = formatarNumConta(numeroDaConta);
        this.setNumConta(numContaFormatada);
    }

    private String formatarNumConta(int[] numeroDaConta) {
        StringBuilder sb = new StringBuilder();
        sb.append(numeroDaConta[0]);
        sb.append(numeroDaConta[1]);
        sb.append(".");
        sb.append(numeroDaConta[2]);
        sb.append(numeroDaConta[3]);
        sb.append(numeroDaConta[4]);
        sb.append("-");
        sb.append(numeroDaConta[5]);
        sb.append(numeroDaConta[6]);

        return sb.toString();
    }

    public void exibirNumConta() {
        if(this.status == true) {
            System.out.println(this.getNumConta());
        } else {
            System.out.println("Acessado negado.");
        }
    }
}