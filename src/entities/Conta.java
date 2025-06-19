package entities;

import exception.ExceptionConta;

public class Conta {

    private Integer numero;
    private String titular;
    private Double saldo;
    private Double saqueLimite;

    public Conta() {
    }

    public Conta(Integer numero, String titular, Double saldo, Double saqueLimite) {
     this.numero = numero;
     this.titular = titular;
     this.saldo = saldo;
     this.saqueLimite = saqueLimite;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public Double getSaldo() {
        return saldo;
    }

    public Double getSaqueLimite() {
        return saqueLimite;
    }

    public Double deposito(Double deposito) {
        depositoPermitido(deposito);
        saldo += deposito;
        return saldo;
    }

    public void saque(Double saque) {
        saquePermitido(saque);
        saldo -= saque;
    }

    private void saquePermitido(Double saque) {
        if(saque > saqueLimite) {
            throw new ExceptionConta("O valor do saque excedeu o limite estabelecido.");
        }
        if(saldo < 0 || saque > saldo) {
            throw new ExceptionConta("A conta não possui saldo suficiente.");
        }
    }

    private void depositoPermitido(Double deposito) {
        if(deposito < 0) {
            throw new ExceptionConta("O depósito não pode ser negativo.");
        }
    }

    @Override
    public String toString() {
        return "Saldo atualizado: R$ " + saldo;
    }
}
