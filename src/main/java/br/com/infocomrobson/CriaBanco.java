package br.com.infocomrobson;

import java.sql.*;

public class CriaBanco {
    public CriaBanco() {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch(ClassNotFoundException cnfe){
            cnfe.printStackTrace();
        }
        Connection conexao = null;
        try{
            String url = "jdbc:mysql://localhost/information_schema";
            String usuario = "root";
            String senha = "Manaus123!@#";
            conexao = DriverManager.getConnection(url, usuario, senha);
        }catch(SQLException sqle){
            sqle.printStackTrace();
            throw new RuntimeException(sqle);
        }

        try {
            Statement stmt = conexao.createStatement();  //conexao é o nome da variável que criamos acima
            int resultado = stmt.executeUpdate("create database if not exists banco");
            System.out.println("Banco criado com sucesso! "+resultado);
        } catch (SQLException e) {
            System.out.println("Erro ao criar o banco!");
            throw new RuntimeException(e);
        }
    }
}
