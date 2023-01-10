package com.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.classes.Professor;

public class ProfessorDAO implements GenericDAO<Professor>{

    @Override
    public Connection getConexao() {
        Connection conexao = null;
        String URL = "jdbc:mariadb://localhost:3306/escola";
        String USER = "local";
        String PASSWORD = "toor";
        try {
            Class.forName("org.mariadb.jdbc.Driver");
            conexao = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Conexão estabelecida!");
            return conexao;
        } catch(ClassNotFoundException | SQLException e){
            System.out.println("Não foi possível estabelecer a conexão!");
            e.printStackTrace();
            return conexao;
        }

    }

    @Override
    public boolean insert(Professor p){
        String sql = "INSERT INTO professor VALUE(?, ?, ?, ?, ?)";
        try {
            Connection con = getConexao();
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, p.getCPF());
            pstm.setString(2, p.getNome());
            pstm.setDouble(3, p.getSalario());
            pstm.setString(4, p.getTitulacao());
            pstm.setString(5, p.getEspecializacao());
            pstm.executeUpdate();
            return true;

        } catch (Exception o) {
            o.printStackTrace();
            System.out.println("Não foi possível efetua a inserção!");
        }

        return false;
    }

    @Override
    public Professor select(int id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Professor> select() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Professor> select(String nome) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean update(Professor e) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean delete(Professor e) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean delete(int id) {
        // TODO Auto-generated method stub
        return false;
    }

}
