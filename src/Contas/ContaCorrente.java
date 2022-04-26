package Contas;

public class ContaCorrente extends Conta implements Tributavel {
    private double chequeEspecial;

    public ContaCorrente( String nomeCliente, int agencia, int numeroConta, double saldo, double chequeEspecial ) {
        super(nomeCliente, agencia, numeroConta, saldo);
        this.chequeEspecial = chequeEspecial;
    }
    @Override
    public void transferir( Conta contaDestino, double valor ) {
        double sacado = sacar(valor);
        contaDestino.depositar(sacado);
    }

    @Override
    public double sacar( double valor ) {
        if (valor <= (getSaldo() + chequeEspecial )) {
        saldo = saldo - getSaldo();
        return valor;
    } else {
        System.out.println("Você nao tem saldo suficiente.");
    }
        return valor;
    }

    @Override
    public double depositar( double valor ) {
        setSaldo(getSaldo() + valor);
       return valor;
    }

    public double getChequeEspecial() {
        return chequeEspecial;
    }

    public void setChequeEspecial( double chequeEspecial ) {
        this.chequeEspecial = chequeEspecial;
    }

    public double getSaldo() {
        return this.chequeEspecial + this.saldo;
    }

    /**
     * Retorna o valor total do saldo mais o limite do cheque especial
     * @return
     */
    public double getSaldoDisponivel() {
        return this.chequeEspecial + this.saldo;
    }

    @Override
    public String toString() {
        return "ContaCorrente{" +
                "saldo=" + saldo +
                ", chequeEspecial=" + chequeEspecial +
                '}';
    }


    @Override
    public double TaxaDeservico(double valor) {
        return this.sacar(valor) - (0.01 - saldo);
    }




}


