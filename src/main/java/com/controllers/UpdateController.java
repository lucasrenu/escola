package com.controllers;

import javafx.fxml.FXML;
import java.io.IOException;
import com.classes.Professor;
import com.utils.ProfessorDAO;
import javafx.scene.control.TextField;

public class UpdateController extends BaseController{
    private int idProfessor;

    @FXML
    private TextField txtIdPesquisar;

    @FXML
    private TextField txtCpf;

    @FXML
    private TextField txtEspecializacao;

    @FXML
    private TextField txtNome;

    @FXML
    private TextField txtSalario;

    @FXML
    private TextField txtTitulacao;

    @FXML
    void mudarParaCadastro() throws IOException {
        App.setRoot("telacadastro");
    }

    @FXML
    void atualizarCadastro() {
        ProfessorDAO dao = new ProfessorDAO();
        //TODO: Fazer validação dos campos;

        Professor prof = new Professor();
        prof.setId(idProfessor);
        prof.setCpf(txtCpf.getText());
        prof.setNome(txtNome.getText());
        prof.setTitulacao(txtTitulacao.getText());
        prof.setEspecializacao(txtEspecializacao.getText());
        prof.setSalario(Double.parseDouble(txtSalario.getText()));

        if(dao.update(prof)){
            System.out.println("Atualização bem sucedida!");
            txtCpf.setText("");
            txtNome.setText("");
            txtSalario.setText("");
            txtTitulacao.setText("");
            txtEspecializacao.setText("");
        } else {
            System.out.println("Erro na atualização!");
        }
    }

    @FXML
    void selecionarProfessor(){
        ProfessorDAO dao = new ProfessorDAO();
        Professor prof;
        int id = Integer.parseInt(txtIdPesquisar.getText());
        prof = dao.select(id);

        if(prof != null){
            idProfessor = Integer.parseInt(txtIdPesquisar.getText());
            txtCpf.setText(prof.getCpf());
            txtNome.setText(prof.getNome());
            txtTitulacao.setText(prof.getTitulacao());
            txtSalario.setText(""+prof.getSalario());
            txtEspecializacao.setText(prof.getEspecializacao());
        }
        txtIdPesquisar.setText("");
    }
}
