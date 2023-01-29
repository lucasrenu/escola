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
        String USER = "toor";
        String PASSWORD = "1234";

        try {
            Class.forName("org.mariadb.jdbc.Driver");
            conexao = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch(ClassNotFoundException | SQLException e){
            System.out.println("Não foi possível estabelecer a conexão!");
        }
        return conexao;

    }

    @Override
    public boolean insert(Professor p){
        String sql = "INSERT INTO professor(nome, cpf, salario, titulacao, especializacao) VALUE(?, ?, ?, ?, ?)";
        try{
            Connection con = getConexao();
            PreparedStatement pstm = con.prepareStatement(sql);
            pstm.setString(1, p.getNome());
            pstm.setString(2, p.getCpf());
            pstm.setDouble(3, p.getSalario());
            pstm.setString(4, p.getTitulacao());
            pstm.setString(5, p.getEspecializacao());
            pstm.executeUpdate();
            con.close();
            return true;

        } catch (Exception o) {
            System.out.println("Não foi possível efetua a inserção!");
        }

        return false;
    }

    public Professor selectByCPF(String cpf){
        try {
            Connection con = getConexao();
            String sql = "SELECT * FROM professor WHERE cpf = ?";
            PreparedStatement psm = con.prepareStatement(sql);
            psm.setString(1, cpf);
            return criarProfessor(psm.executeQuery());
        } catch(Exception e) {
            System.out.println("Erro, usuário não encontrado.");
        }
        return null;
    }

    @Override
    public List<Professor> select(String nome) {
        String sql = "SELECT * FROM professor WHERE nome = ?";
        try(Connection con = getConexao()){
            if(con != null){
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setString(1, nome);
                ResultSet rs = ps.executeQuery();
                return gerarLista(rs);
            }
        } catch (Exception e) {
            System.out.println("Erro ao selecionar lista de professores");
        }
        return null;
    }

    @Override
    public List<Professor> select() {
        String sql = "SELECT * FROM professor";
        try(Connection con = getConexao()){
            if(con != null){
                PreparedStatement ps = con.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                List<Professor> professores = gerarLista(rs);
                con.close();
                return professores;
            }
        } catch (Exception e) {
            System.out.println("Erro ao selecionar lista de professores");
        }
        return null;
    }

    @Override
    public Professor select(int id) {
        String sql = "SELECT * FROM professor WHERE id = ?";
        try (Connection con = getConexao()){
            if(con!=null){
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setInt(1, id);
                return criarProfessor(ps.executeQuery());
            }
        } catch (SQLException e) {
            System.out.println("Erro ao tentar efetuar seleção pelo ID!");
        }
        return null;
    }

    @Override
    public boolean update(Professor p) {
        try(Connection con = getConexao()){
            if(con != null){
                String sql = "UPDATE professor SET cpf = ?, nome = ?, salario = ?, titulacao = ?, especializacao = ? WHERE id = ?";
                PreparedStatement psm = con.prepareStatement(sql);
                psm.setString(1, p.getCpf());
                psm.setString(2, p.getNome());
                psm.setDouble(3, p.getSalario());
                psm.setString(4, p.getTitulacao());
                psm.setString(5, p.getEspecializacao());
                psm.setInt(6, p.getId());
                psm.executeUpdate();
                con.close();
                return true;
            }
        } catch(Exception e) {
            System.out.println("Erro, usuário não encontrado.");
        }
        return false;
    }

    @Override
    public boolean delete(Professor p) {
        String sql = "DELETE FROM professor WHERE id = ? AND cpf = ?";
        try (Connection con = getConexao()){
            if(con!=null){
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setInt(1, p.getId());
                ps.setString(2, p.getCpf());
                ps.executeUpdate();
                con.close();
                return true;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao tentar deletar professor!");
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        String sql = "DELETE FROM professor WHERE id = ?";
        try (Connection con = getConexao()){
            if(con != null){
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setInt(1, id);
                return ps.execute();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    private List<Professor> gerarLista(ResultSet rs){
        List<Professor> profs = new ArrayList<>();
        try {
            while(rs.next()){
                Professor prof =  new Professor();
                prof.setId(rs.getInt("id"));
                prof.setCpf(rs.getString("cpf"));
                prof.setNome(rs.getString("nome"));
                prof.setEspecializacao(rs.getString("especializacao"));
                prof.setTitulacao(rs.getString("titulacao"));
                prof.setSalario(rs.getDouble("salario"));
                profs.add(prof);
            }
        } catch(SQLException r){
            r.printStackTrace();
            System.out.println("Erro ao Gerar Lista de Professores");
        }
        return profs;
    };

    private Professor criarProfessor(ResultSet rs){
        try{
            rs.next();
            Professor prof = new Professor();
            prof.setId(rs.getInt("id"));
            prof.setCpf(rs.getString("cpf"));
            prof.setNome(rs.getString("nome"));
            prof.setSalario(rs.getDouble("salario"));
            prof.setTitulacao(rs.getString("titulacao"));
            prof.setEspecializacao(rs.getString("especializacao"));
            return prof;
        } catch(SQLException e){
            System.out.println("Erro ao gerrar lista de professores; ProfessorDAO.criarProfessor");
        }
        return null;
    }
}
