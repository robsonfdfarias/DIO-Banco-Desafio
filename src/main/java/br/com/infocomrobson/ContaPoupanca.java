package br.com.infocomrobson;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@NoArgsConstructor @AllArgsConstructor
@Getter
@ToString
@EqualsAndHashCode
@Table(name = "tb_poupanca")
public class ContaPoupanca extends Conta{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "saldo")
    @Setter private double saldo;

    @Column(name = "agencia")
    protected Integer agencia = 1;

    @Column(name = "numeracao")
    @Setter private Integer numero;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cliente_id", nullable = false)
    @Setter private Cliente cliente;

    public void depositarPoup(double valor){
        double vv = getSaldo();
        setSaldo(super.depositar(valor, vv));
        Consultas consultas = new Consultas();
        consultas.atualizaPoup(this);
    }

    public void sacarPoup(double valor){
        double vv = getSaldo();
        setSaldo(super.sacar(valor, vv));
        Consultas consultas = new Consultas();
        consultas.atualizaPoup(this);
    }

    public void transferir(double valor, ContaPoupanca contaPoupanca){
        List<Double> vari = super.transferencia(valor, getSaldo());
        if(vari.get(0) != null){
            setSaldo(vari.get(0));
            contaPoupanca.depositarPoup(vari.get(1));
        }else{
            System.out.println("Saldo insuficiente ou erro na transferência...");
        }
        Consultas consultas = new Consultas();
        consultas.atualizaPoup(contaPoupanca);
        consultas.atualizaPoup(this);
    }

    public void transferir(double valor, ContaCorrente contaCorrente){
        List<Double> vari = super.transferencia(valor, saldo);
        if(vari.get(0) != null){
            setSaldo(vari.get(0));
            contaCorrente.depositarCorr(vari.get(1));
        }else{
            System.out.println("Objeto vazio.....");
        }
        Consultas consultas = new Consultas();
        consultas.atualizaCorr(contaCorrente);
        consultas.atualizaPoup(this);
    }


    public void extrato() {
        System.out.println("Extrato conta poupança");
        super.imprimirExtrato(cliente, agencia, numero, saldo);
    }
}
