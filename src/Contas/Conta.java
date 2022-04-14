package Contas;

public abstract class Conta {
    private String nomeCliente;
    private int agencia;
    private int numeroConta;
    protected double saldo;

    public Conta( String nomeCliente, int agencia, int numeroConta, double saldo ) {
        this.nomeCliente = nomeCliente;
        this.agencia = agencia;
        this.numeroConta = numeroConta;
        this.saldo = saldo;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente( String nomeCliente ) {
        this.nomeCliente = nomeCliente;
    }

    public int getAgencia() {
        return agencia;
    }

    public void setAgencia( int agencia ) {
        this.agencia = agencia;
    }

    public int getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta( int numeroConta ) {
        this.numeroConta = numeroConta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo( double saldo ) {
        this.saldo = saldo;
    }
    protected abstract void transferir( Conta contaDestino, double valor );
    protected abstract double sacar( double valor );
    protected abstract double depositar( double valor );

    @Override
    public String toString() {
        return "Conta{" +
                "nomeCliente='" + nomeCliente + '\'' +
                ", agencia=" + agencia +
                ", numeroConta=" + numeroConta +
                ", saldo=" + saldo +
                '}';
    }
}
