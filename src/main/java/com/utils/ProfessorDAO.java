package com.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.classes.Professor;

public class ProfessorDAO implements GenericDAO<Professor>{

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

    public Professor selectByCPF(String cpf){
        try {
            Connection con = getConexao();
            String sql = "SELECT * FROM professor WHERE cpf = ?";
            PreparedStatement psm = con.prepareStatement(sql);
        } catch(Exception e) {
            System.out.println("Erro, usuário não encontrado.");
        }
        return null;
    }

    @Override
    public List<Professor> select(String nome) {
        return null;
    }

    @Override
    public List<Professor> select() {
        String sql = "SELECT * FROM professor";
        try {
            Connection con = getConexao();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            List<Professor> professores = gerarLista(rs);
            return professores;
        } catch (Exception e) {
            System.out.println("Erro ao selecionar lista de professores");
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Professor select(int id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean update(Professor p) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean delete(Professor p) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean delete(int cpf) {
        String sql = "delete from ? where cpf = ?";
        try {
            Connection con = getConexao();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.execute();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private List<Professor> gerarLista(ResultSet rs){
        List<Professor> profs = new ArrayList<>();
        try {
            while(rs.next()){
                Professor prof =  new Professor();
                prof.setCPF(rs.getString("cpf"));
                prof.setNome(rs.getString("nome"));
                prof.setEspecializacao(rs.getString("especializacao"));
                prof.setTitulacao(rs.getString("titulacao"));
                prof.setSalario(rs.getDouble("salario"));
                profs.add(prof);
            }
            return profs;
        } catch(Exception r){
            r.printStackTrace();
            System.out.println("Erro ao Gerar Lista de Professores");
        }
        return null;
    }
}
