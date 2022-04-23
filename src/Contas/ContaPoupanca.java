package Contas;

import java.util.Date;

public class ContaPoupanca extends Conta{
    private int dataCadastro;
    private double taxaJuros = 0.05;

    public ContaPoupanca( String nomeCliente, int agencia, int numeroConta, double saldo, Date diaAniversario, double taxaJuros ) {
        super(nomeCliente, agencia, numeroConta, saldo);
        this.dataCadastro = dataCadastro;
        this.taxaJuros = taxaJuros;
    }

    public int getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro( int dataCadastro ) {
        this.dataCadastro = dataCadastro;
    }

    public double getTaxaJuros() {
        return taxaJuros;
    }

    public void setTaxaJuros( double taxaJuros ) {
        this.taxaJuros = taxaJuros;
    }


    @Override
    public void transferir( Conta contaDestino, double valor ) {
         double sacado = sacar(valor);
        contaDestino.depositar(sacado);

    }

    @Override
    public double sacar( double valor ) {
        if (valor <= (getSaldo())){
            saldo = saldo - valor;
            return valor;
        } else {
            System.out.println("Vc nao tem saldo suficiente.");
        }

        return valor;
    }

    @Override
    public double depositar( double valor ) {
        setSaldo(getSaldo() + valor);

        return valor;
    }
    public double getSaldo() {
        return this.saldo * this.taxaJuros + this.saldo;
    }

    @Override
    public String toString() {
        return "ContaPoupanca{" +
                "saldo=" + saldo +
                ", dataCadastro=" + dataCadastro +
                ", taxaJuros=" + taxaJuros +
                '}';
    }

}
