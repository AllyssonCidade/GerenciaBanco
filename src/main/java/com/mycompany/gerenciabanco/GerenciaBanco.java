package com.mycompany.gerenciabanco;

import java.util.Scanner;

class User {
    private String fullName;
    private String cpf;
    private double saldo;
    
    public User(String nome, String sobreNome, String cpf, double saldo){
        this.fullName = nome + sobreNome;
        this.cpf = cpf;
        this.saldo = saldo;
    }
    public void depositar(double valor){
        if (valor > 0){
            saldo += valor;
            System.out.println("Deposito realizado no valor de:" + valor);
        }else{
            System.out.println("Valor deve ser maior que zero");
        }
    }
    
    public void sacar(double valor){
        if(saldo >= valor){
            saldo -= valor;
            System.out.println("Saque realizado no valor de: R$ " + valor + ".");
        }else{
            System.out.println("Saldo insuficiente!");
        }
    }
    
    public void consultarSaldo(){
        System.out.println("Saldo atual: R$ " + saldo);
    }
}

public class GerenciaBanco {
    
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner (System.in)) {
            System.out.print("informe o nome!");
            String nome = scanner.nextLine();
            
            System.out.print("Informe seu sobre nome!");
            String sobreNome = scanner.nextLine();
            
            System.out.print("Informe seu cpf!");
            String cpf = scanner.nextLine();
            
            User usuario = new User(nome, sobreNome, cpf, 0.0);
            
            int opcao;
            do{
                System.out.println("\nEscolha uma opção!");
                System.out.println("1- Consultar Saldo");
                System.out.println("2 - Realizar depósito");
                System.out.println("3 - Realizar um saque");
                System.out.println("4 - Encerrar operação");
                
                System.out.println("Opção:");
                opcao = scanner.nextInt();
                switch(opcao){
                    case 1 -> usuario.consultarSaldo();
                    case 2 -> {
                        System.out.print("informe o valor do depósito a ser realizado!");
                        double deposito = scanner.nextDouble();
                        usuario.depositar(deposito);
                    }
                        
                    case 3 -> {
                        System.out.print("informe o valor do saque a ser realizado!");
                        double saque = scanner.nextDouble();
                        usuario.sacar(saque);
                    }
                        
                    case 4 -> System.out.print("Obrigado por realizar nossos serviços!");
                    default -> System.out.println("opção inválida!");
                }
            }while(opcao !=4);
        }
    }
}
