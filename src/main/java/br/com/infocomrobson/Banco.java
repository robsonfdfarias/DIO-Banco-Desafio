package br.com.infocomrobson;

import lombok.*;

import java.util.List;
@NoArgsConstructor @AllArgsConstructor
@Getter
@Setter
public class Banco {
    private String nome;
    private List<Conta> contas;
    private List<ContaPoupanca> contaPoupancas;
    private List<ContaCorrente> contaCorrentes;

    public void contas(){
        Consultas consultas = new Consultas();
        System.out.println("Conta Poupança");
        contaPoupancas = consultas.consultaPoup();
        contaPoupancas.forEach(ContaPoupanca -> ContaPoupanca.extrato());
        System.out.println("Conta Corrente");
        contaCorrentes = consultas.consultaCorr();
        contaCorrentes.forEach(ContaCorrente -> ContaCorrente.extrato());
    }
}
