package br.com.infocomrobson.Interface;

import br.com.infocomrobson.Cliente;
import br.com.infocomrobson.Conta;

import java.util.List;

public interface IConta {
    double depositar(double valor, double saldo);

    double sacar(double valor, double saldo);

    List<Double> transferencia(double valor, double saldo);

    void imprimirExtrato(Cliente cliente, int agencia, int numero, double saldo);
}
