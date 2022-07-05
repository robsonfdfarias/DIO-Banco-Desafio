package br.com.infocomrobson;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.Collections;

public class InserirRegistrosExemplo {
    public InserirRegistrosExemplo() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Banco");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        //Usuário e conta 1
        entityManager.getTransaction().begin();
        Endereco endereco = new Endereco();
        endereco.setNumero("192");
        endereco.setRua("BR-280");
        endereco.setBairro("Centro");
        endereco.setCidade("Bombinhas");
        endereco.setEstado("Santa Catarina");

        Cliente cliente = new Cliente();
        cliente.setNome("Robson Farias");
        cliente.setEnderecos(Collections.singletonList(endereco));
        cliente.setNascimento("20-10-1988");
        cliente.setProfissao("FullStack");

        ControleNumeracao controleNumeracao = new ControleNumeracao();
        controleNumeracao.numeracao(controleNumeracao.tipoPoup());
        entityManager.persist(controleNumeracao);
        int num = controleNumeracao.getId();
        ContaPoupanca contaPoupanca = new ContaPoupanca();
        contaPoupanca.setCliente(cliente);
//        contaPoupanca.depositarPoup(1200);
        contaPoupanca.setNumero(num);

        cliente.setContaPoupanca(contaPoupanca);
        endereco.setCliente(cliente);
        entityManager.persist(cliente);
        entityManager.getTransaction().commit();




        //Usuário e conta 2
        entityManager.getTransaction().begin();
        Endereco endereco2 = new Endereco();
        endereco2.setNumero("192");
        endereco2.setRua("BR-280");
        endereco2.setBairro("Centro");
        endereco2.setCidade("Bombinhas");
        endereco2.setEstado("Santa Catarina");

        Cliente cliente2 = new Cliente();
        cliente2.setNome("Camila Couto");
        cliente2.setEnderecos(Collections.singletonList(endereco2));
        cliente2.setNascimento("20-10-1989");
        cliente2.setProfissao("Bio-médica");

        ControleNumeracao controleNumeracao2 = new ControleNumeracao();
        controleNumeracao2.numeracao(controleNumeracao2.tipoPoup());
        entityManager.persist(controleNumeracao2);
        int num2 = controleNumeracao2.getId();

        ContaPoupanca contaPoupanca2 = new ContaPoupanca();
        contaPoupanca2.setCliente(cliente2);
//        contaPoupanca2.depositarPoup(1100);
        contaPoupanca2.setNumero(num2);

        cliente2.setContaPoupanca(contaPoupanca2);
        endereco2.setCliente(cliente2);
        entityManager.persist(cliente2);
        entityManager.getTransaction().commit();




        //Usuário e conta 3
        entityManager.getTransaction().begin();
        Endereco endereco3 = new Endereco();
        endereco3.setNumero("500");
        endereco3.setRua("forquinha");
        endereco3.setBairro("Cidade de Deus");
        endereco3.setCidade("Manaus");
        endereco3.setEstado("Amazonas");

        Cliente cliente3 = new Cliente();
        cliente3.setNome("Tony Herbert");
        cliente3.setEnderecos(Collections.singletonList(endereco3));
        cliente3.setNascimento("20-10-1983");
        cliente3.setProfissao("DEV");

        ControleNumeracao controleNumeracao3 = new ControleNumeracao();
        controleNumeracao3.numeracao(controleNumeracao3.tipoCorr());
        entityManager.persist(controleNumeracao3);
        int num3 = controleNumeracao3.getId();

        ContaCorrente contaCorrente3 = new ContaCorrente();
        contaCorrente3.setCliente(cliente3);
//        contaCorrente3.depositarCorr(1300);
//        contaCorrente3.sacarCorr(500);
        contaCorrente3.setNumero(num3);
        contaCorrente3.extrato();

        cliente3.setContaCorrente(contaCorrente3);
        endereco3.setCliente(cliente3);
        entityManager.persist(cliente3);
        entityManager.getTransaction().commit();


        entityManager.close();
        entityManagerFactory.close();

    }
}
