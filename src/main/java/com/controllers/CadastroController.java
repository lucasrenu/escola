package com.controllers;

import java.io.IOException;

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
        txCpf.getText();
        txEspecializacao.getText();
        txNome.getText();
        Double.parseDouble(txSalario.getText());
        txTitulacao.getText();
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

