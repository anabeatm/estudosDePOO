import java.util.Scanner;

public class ContaBanco {
    private int numConta;
    protected String tipo;
    private float saldo;
    private boolean status;

    Scanner in = new Scanner(System.in);

    public void setNumConta(int numeroConta) {
        numConta = numeroConta;
    }
    public int getNumConta() {
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
        status = false;
        saldo = 0.0f;
    }

    public void abrirConta(String tipoConta) {
        this.status = true;
        this.setTipo(tipoConta);
        if(tipoConta.equals("cc")) {
            saldo = 50f;
            this.setSaldo(saldo);
        } else if (tipoConta.equals("cp")) {
            saldo = 150f;
            this.setSaldo(saldo);
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
    }

    public void visualizarContaBancaria() {
        System.out.printf("""
                Tipo: %s
                Saldo: R$%s
                Status: %s\n""", getTipo(), getSaldo(), getStatus());
    }

}