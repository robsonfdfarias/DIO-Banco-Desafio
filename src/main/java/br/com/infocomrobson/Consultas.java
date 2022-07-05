package br.com.infocomrobson;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class Consultas {
    EntityManagerFactory entityManagerFactory = null;
    EntityManager entityManager = null;

    public List<ContaPoupanca> consultaPoup(){
        List<ContaPoupanca> contas;
        conn();
        String jpql = "select c from ContaPoupanca c join fetch c.cliente cliente join fetch cliente.enderecos enderecos where c.id > :id";
//        String jpql = "select c from ContaPoupanca c join fetch c.cliente cliente join fetch cliente.enderecos enderecos where c.id > :id and cliente.id > :clienteId";
        contas = entityManager
                .createQuery(jpql, ContaPoupanca.class)
                        .setParameter("id", 0)
//                        .setParameter("clienteId", 0)
                                .getResultList();
        fecha();
        return contas;
    }

    public List<ContaCorrente> consultaCorr(){
        List<ContaCorrente> contas;
        conn();
        String jpql = "select c from ContaCorrente c join fetch c.cliente cliente join fetch cliente.enderecos enderecos where c.id > :id";
        contas = entityManager
                .createQuery(jpql, ContaCorrente.class)
                        .setParameter("id", 0)
                                .getResultList();
        fecha();
        return contas;
    }

    public ContaPoupanca findContaPoupNome(String nome){
        ContaPoupanca conta = null;
        conn();
        String jpql = "select c from ContaPoupanca c join fetch c.cliente cliente join fetch cliente.enderecos enderecos where c.id > :id and cliente.nome like CONCAT('%', :clienteNome ,'%')";
        conta = entityManager
                .createQuery(jpql, ContaPoupanca.class)
                        .setParameter("id", 0)
                                .setParameter("clienteNome", nome)
                                        .getSingleResult();
        fecha();
        return conta;
    }

    public ContaCorrente findContaCorrNome(String nome){
        ContaCorrente conta = null;
        conn();
        String jpql = "select c from ContaCorrente c join fetch c.cliente cliente join fetch cliente.enderecos enderecos where c.id > :id and cliente.nome like CONCAT('%', :clienteNome ,'%')";
        conta = entityManager
                .createQuery(jpql, ContaCorrente.class)
                        .setParameter("id", 0)
                                .setParameter("clienteNome", nome)
                                        .getSingleResult();
        fecha();
        return conta;
    }

    public List<ContaPoupanca> findContaPoupListNome(String nome){
        List<ContaPoupanca> contas = null;
        conn();
        String jpql = "select c from ContaPoupanca c join fetch c.cliente cliente join fetch cliente.enderecos enderecos where c.id > :id and cliente.nome like CONCAT('%', :clienteNome ,'%')";
        contas = entityManager
                .createQuery(jpql, ContaPoupanca.class)
                        .setParameter("id", 0)
                                .setParameter("clienteNome", nome)
                                        .getResultList();
        fecha();
        return contas;
    }

    public List<ContaCorrente> findContaCorrListNome(String nome){
        List<ContaCorrente> contas = null;
        conn();
        String jpql = "select c from ContaCorrente c join fetch c.cliente cliente join fetch cliente.enderecos enderecos where c.id > :id and cliente.nome like CONCAT('%', :clienteNome ,'%')";
        contas = entityManager
                .createQuery(jpql, ContaCorrente.class)
                        .setParameter("id", 0)
                                .setParameter("clienteNome", nome)
                                        .getResultList();
        fecha();
        return contas;
    }

    public void conn(){
        entityManagerFactory = Persistence.createEntityManagerFactory("Banco");
        entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
    }

    public void fecha(){
        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();
    }

    public void atualizaPoup(ContaPoupanca contaPoupanca){
        conn();
        entityManager.merge(contaPoupanca);
        fecha();
    }

    public void atualizaCorr(ContaCorrente contaCorrente){
        conn();
        entityManager.merge(contaCorrente);
        fecha();
    }

}
