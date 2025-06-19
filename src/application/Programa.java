package application;

import entities.Conta;
import exception.ExceptionConta;

import java.util.Scanner;

public class Programa {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("--- Entre com os dados da conta --- ");
        System.out.print("Numero da conta: ");
        int numero = sc.nextInt();
        sc.nextLine();
        System.out.print("Digite o nome do titular: ");
        String titular = sc.nextLine();
        System.out.print("Digite o saldo da conta: ");
        Double saldo = sc.nextDouble();
        System.out.print("Digite o limite de saque: ");
        Double saqueLimite = sc.nextDouble();
        Conta conta = new Conta(numero, titular, saldo, saqueLimite);


        System.out.println();
        System.out.print("Digite o valor que deseja depositar: ");
        Double valorDeposito = sc.nextDouble();
        try {
            conta.deposito(valorDeposito);
            System.out.printf("Saldo após o deposito R$: %.2f", conta.deposito(valorDeposito));
        } catch (ExceptionConta e) {
            System.out.println(e.getMessage());
        }

        System.out.println();
        System.out.print("Digite o valor que deseja sacar: ");
        Double valorSaque = sc.nextDouble();

        try {
            conta.saque(valorSaque);
            System.out.printf("Saldo após o saque R$: %.2f", conta.getSaldo());

        } catch (ExceptionConta e) {
            System.out.println(e.getMessage());
        }

        sc.close();
    }
}