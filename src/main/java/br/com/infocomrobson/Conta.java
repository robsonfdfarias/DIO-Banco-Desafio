package br.com.infocomrobson;

import br.com.infocomrobson.Interface.IConta;

import java.util.ArrayList;
import java.util.List;

public class Conta implements IConta {

    public Conta() {
    }

    public double depositar(double valor, double saldo){
        saldo += valor;
        return saldo;
    }

    public double sacar(double valor, double saldo){
        if(valor>saldo){
            System.out.println("Saldo insuficiente para a transação!");
            System.out.println("Seu saldo é de: "+saldo);
            return 0;
        }
        saldo -= valor;
        return saldo;
    }

    public List<Double> transferencia(double valor, double saldo){
        List<Double> valores = new ArrayList<>();
        if(valor > saldo){
            System.out.println("Saldo insuficiente para a transação!");
            System.out.println("Seu saldo é de: "+saldo);
            valores.add(null);
            return valores;
        }
        valores.add(saldo-valor);
        valores.add(valor);
        return valores;
    }

    public void imprimirExtrato(Cliente cliente, int agencia, int numero, double saldo){
        System.out.println("Cliente: "+ cliente.getNome());
        System.out.printf("Agencia: %d%n", agencia);
        System.out.printf("Número: %d%n", numero);
        System.out.printf("Saldo: %.2f%n", saldo);
    }
}
