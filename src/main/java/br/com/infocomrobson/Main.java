package br.com.infocomrobson;

import jakarta.persistence.NoResultException;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        CriaBanco criaBanco = new CriaBanco();
        InserirRegistrosExemplo inserirRegistrosExemplo = new InserirRegistrosExemplo();

        Consultas consultas = new Consultas();
        try{
            List<ContaPoupanca> contaPoupanca = consultas.consultaPoup();
            contaPoupanca.forEach(ContaPoupanca -> ContaPoupanca.depositarPoup(1500));
            contaPoupanca.forEach(Conta -> System.out.println("CLiente: "+Conta.getCliente().getNome()+
                    " - Conta: "+Conta.getNumero()+" - Saldo: "+Conta.getSaldo()
                    +" - Endereco: Rua "+Conta.getCliente().getEnderecos().get(0).getRua()
                    +", Nº "+Conta.getCliente().getEnderecos().get(0).getNumero()
                    +", "+Conta.getCliente().getEnderecos().get(0).getBairro()
                    +", "+Conta.getCliente().getEnderecos().get(0).getCidade()
                    +", "+Conta.getCliente().getEnderecos().get(0).getEstado()));
            contaPoupanca.get(0).depositarPoup(200);
            contaPoupanca.get(0).transferir(50.0, contaPoupanca.get(1));
            contaPoupanca.forEach(Conta -> System.out.println("CLiente: "+Conta.getCliente().getNome()+
                    " - Conta: "+Conta.getNumero()+" - Saldo: "+Conta.getSaldo()
                    +" - Endereco: Rua "+Conta.getCliente().getEnderecos().get(0).getRua()
                    +", Nº "+Conta.getCliente().getEnderecos().get(0).getNumero()
                    +", "+Conta.getCliente().getEnderecos().get(0).getBairro()
                    +", "+Conta.getCliente().getEnderecos().get(0).getCidade()
                    +", "+Conta.getCliente().getEnderecos().get(0).getEstado()));
        } catch (IndexOutOfBoundsException | NoResultException e) {
            System.out.println("Usuário não encontrado 111");
        }

        List<ContaCorrente> contasCorr = consultas.consultaCorr();
//        contasCorr.get(0).depositarCorr(1000);
        for(ContaCorrente cc : contasCorr){
            cc.depositarCorr(1500);
        }
        contasCorr.forEach(Conta -> System.out.println("CLiente: "+Conta.getCliente().getNome()+
                " - Conta: "+Conta.getNumero()+" - Saldo: "+Conta.getSaldo()
                +" - Endereco: Rua "+Conta.getCliente().getEnderecos().get(0).getRua()
                +", Nº "+Conta.getCliente().getEnderecos().get(0).getNumero()
                +", "+Conta.getCliente().getEnderecos().get(0).getBairro()
                +", "+Conta.getCliente().getEnderecos().get(0).getCidade()
                +", "+Conta.getCliente().getEnderecos().get(0).getEstado()));


        System.out.println("");
        try{
            ContaPoupanca conta = consultas.findContaPoupNome("Robson");
//            Cliente cliente = conta.getCliente();
            System.out.println("CLiente: "+conta.getCliente().getNome()+
                    " - Conta: "+conta.getNumero()+" - Saldo: "+conta.getSaldo()
                    +" - Endereco: Rua "+conta.getCliente().getEnderecos().get(0).getRua()
                    +", Nº "+conta.getCliente().getEnderecos().get(0).getNumero()
                    +", "+conta.getCliente().getEnderecos().get(0).getBairro()
                    +", "+conta.getCliente().getEnderecos().get(0).getCidade()
                    +", "+conta.getCliente().getEnderecos().get(0).getEstado());
        } catch (IndexOutOfBoundsException | NoResultException e) {
            System.out.println("Usuário não encontrado");
            //throw new RuntimeException(e);
        }


        try{
            List<ContaPoupanca> contas1 = consultas.findContaPoupListNome("Farias");
            Cliente cliente = contas1.get(0).getCliente();
            contas1.forEach(Conta -> System.out.println("CLiente: "+Conta.getCliente().getNome()+
                    " - Conta: "+Conta.getNumero()+" - Saldo: "+Conta.getSaldo()
                    +" - Endereco: Rua "+Conta.getCliente().getEnderecos().get(0).getRua()
                    +", Nº "+Conta.getCliente().getEnderecos().get(0).getNumero()
                    +", "+Conta.getCliente().getEnderecos().get(0).getBairro()
                    +", "+Conta.getCliente().getEnderecos().get(0).getCidade()
                    +", "+Conta.getCliente().getEnderecos().get(0).getEstado()));
            contas1.forEach(Conta -> Conta.extrato());
        } catch (IndexOutOfBoundsException | NoResultException e) {
            System.out.println("Usuário não encontrado 222");
            //throw new RuntimeException(e);
        }


        try{
            List<ContaCorrente> contas2 = consultas.findContaCorrListNome("Herbert");
            Cliente cliente = contas2.get(0).getCliente();
            contas2.forEach(Conta -> System.out.println("CLiente: "+Conta.getCliente().getNome()+
                    " - Conta: "+Conta.getNumero()+" - Saldo: "+Conta.getSaldo()
                    +" - Endereco: Rua "+Conta.getCliente().getEnderecos().get(0).getRua()
                    +", Nº "+Conta.getCliente().getEnderecos().get(0).getNumero()
                    +", "+Conta.getCliente().getEnderecos().get(0).getBairro()
                    +", "+Conta.getCliente().getEnderecos().get(0).getCidade()
                    +", "+Conta.getCliente().getEnderecos().get(0).getEstado()));
            contas2.forEach(Conta -> Conta.extrato());
        } catch (IndexOutOfBoundsException | NoResultException e) {
            System.out.println("Usuário não encontrado");
            //throw new RuntimeException(e);
        }

        //Transferindo da conta poupança para corrente
        try{
            ContaPoupanca cp = consultas.findContaPoupNome("Robson");
//            cp.extrato();
            ContaCorrente cc = consultas.findContaCorrNome("Tony");
//            cc.extrato();
            cp.transferir(50.0, cc);
            cp.extrato();
            cc.extrato();
        } catch (IndexOutOfBoundsException | NoResultException e) {
            System.out.println("Usuário não encontrado");
            //throw new RuntimeException(e);
        } catch (IllegalStateException e){
            System.out.println("Ilegal o state exceção");
        }


        System.out.println("");
        Banco banco = new Banco();
        banco.contas();
    }
}
