package com.controllers;

import java.io.IOException;


import com.classes.Professor;
import com.utils.ProfessorDAO;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class CadastroController {
    @FXML private Button btCadastrarProfessor;

    @FXML private Button btDeletarcd;

    @FXML private Button btPesquisarCadastro;

    @FXML private TextField txCpf;

    @FXML private TextField txEspecializacao;

    @FXML private TextField txNome;

    @FXML private TextField txSalario;

    @FXML private TextField txTitulacao;

    @FXML private Label msg;

    @FXML void Cadastrar() {
        Professor professorAt = new Professor();
        if(txCpf.getText() != null && !txCpf.getText().trim().isEmpty() &&  txEspecializacao.getText() != null && !txEspecializacao.getText().trim().isEmpty() && txNome.getText() != null && !txNome.getText().trim().isEmpty() && txSalario.getText() != null && !txSalario.getText().trim().isEmpty() && txTitulacao.getText() != null && !txTitulacao.getText().trim().isEmpty()){
            professorAt.setCpf(txCpf.getText());
            professorAt.setEspecializacao(txEspecializacao.getText());
            professorAt.setNome(txNome.getText());
            professorAt.setSalario(Double.parseDouble(txSalario.getText()));
            professorAt.setTitulacao(txTitulacao.getText());   
        }


        // !nome.trim().isEmpty()
        txCpf.setText("");
        txEspecializacao.setText("");
        txNome.setText("");
        txTitulacao.setText("");
        ProfessorDAO professor  = new ProfessorDAO();
        professor.insert(professorAt);
    }

    @FXML
    void mudarTelaDeletar() throws IOException {
        App.setRoot("teladeletar");
    }

    @FXML
    void mudarTelaPesquisa() throws IOException {
        App.setRoot("telapesquisa");
    }
}

