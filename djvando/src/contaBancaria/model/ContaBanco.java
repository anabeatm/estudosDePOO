package contaBancaria.model;
import java.util.Random;

public class ContaBanco {
    private String numConta;
    protected String tipo;
    private float saldo;
    private boolean status;


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

    /**
     * Construtor da conta bancária. Aqui o status é false e o saldo 0.0.
     * Automaticamente é gerado o número da conta ao instanciar.
     */
    public ContaBanco() {
        this.setStatus(false);
        this.saldo = 0.0f;
        gerarNumeroDaConta();
    }

    /**
    Abrir conta bancária.
     O status da conta se torna true.
     @param tipoConta
     */
    public void abrirConta(String tipoConta) {
        this.status = true;
        this.setTipo(tipoConta);

        if(tipoConta.equals("cc")) {
            this.setSaldo(50f);

        } else if (tipoConta.equals("cp")) {
            this.setSaldo(150f);

        } else {
            System.out.println("Ação Inválida!");
        }
    }

    /**
     * Sacar qualquer valor que seja válido.
     * O satus da conta precisa ser true e o valor tem que estar na conta.
     * @param valorSerSacado
     */
    public void sacar(float valorSerSacado) {
        if(this.getStatus()) {
            System.out.println("Total: " + this.getSaldo());

            if (valorSerSacado > this.getSaldo()) {
                System.out.println("Valor impossível de sacar.");

            } else {
                this.setSaldo(this.getSaldo() - valorSerSacado);
                System.out.println("Valor sacado!");
            }

        } else{
            System.out.println("Impossível sacar.");
        }
    }

    /**
     * Para fechar a conta bancária. Aqui é preciso que todo o valor seja sacado anteriormente.
     * Seu status passa ser false.
     * @param valorSerSacado
     */
    public void fecharConta(float valorSerSacado) {
        this.sacar(valorSerSacado);

        if(this.getSaldo() > 0) {

            System.out.println("Impossível de fechar a conta!");

        } else {
            this.status = false;
            System.out.println("Conta fechada!");
        }
    }

    public void depositar(float valorDepositar) {
        if(this.getStatus()) {
            System.out.println("Total: " + this.getSaldo());

            if(valorDepositar < 0) {
                System.out.println("Valor impossível de depositar.");

            } else {
                this.setSaldo(this.getSaldo() + valorDepositar);
                System.out.println("Valor depositado!");
            }

        } else {
            System.out.println("Impossível depositar.");
        }
    }

    public void pagarMensal() {
        float mensalidade;
        if(this.getStatus()) {

            if(this.getTipo().equals("cc")) {
                mensalidade = 12f;
                this.setSaldo(this.getSaldo() - mensalidade);
                System.out.println("Valor de R$12 a.m pago!");
                System.out.println("Valor total: " + getSaldo());

            } else if (this.getTipo().equals("cp")) {
                mensalidade = 20f;
                this.setSaldo(this.getSaldo() - mensalidade);
                System.out.println("Valor de R$20 a.m pago!");
                System.out.println("Valor total: " + getSaldo());
            }

        } else {
            System.out.println("Acesso negado.");
        }
    }

    public void visualizarContaBancaria() {
        if(this.status) {
        System.out.printf("""
                Número da Conta: %s
                Tipo: %s
                Saldo: R$%s
                Status: %s
                """, getNumConta(), getTipo(), getSaldo(), getStatus());

        } else {
            System.out.println("Conta inexistente.");
        }
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

        return String.valueOf(numeroDaConta[0]) +
                numeroDaConta[1] +
                "." +
                numeroDaConta[2] +
                numeroDaConta[3] +
                numeroDaConta[4] +
                "-" +
                numeroDaConta[5] +
                numeroDaConta[6];
    }

    public void exibirNumConta() {
        if(this.status) {
            System.out.println(this.getNumConta());

        } else {
            System.out.println("Acessado negado.");
        }
    }
}