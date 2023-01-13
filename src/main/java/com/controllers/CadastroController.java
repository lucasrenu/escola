package com.controllers;

import java.io.IOException;


import com.classes.Professor;
import com.utils.ProfessorDAO;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
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

    @FXML void Cadastrar() {
        Professor professorAt = new Professor();
        professorAt.setCpf(txCpf.getText());
        professorAt.setEspecializacao(txEspecializacao.getText());
        professorAt.setNome(txNome.getText());
        professorAt.setSalario(Double.parseDouble(txSalario.getText()));
        professorAt.setTitulacao(txTitulacao.getText());

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

