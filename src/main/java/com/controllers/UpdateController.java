package com.controllers;

import java.io.IOException;

import com.classes.Professor;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class UpdateController {

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
    void atualizarCadastro() {
        
    }

    @FXML
    void mudarParaCadastro() throws IOException {
        App.setRoot("telacadastro");
    }

    @FXML
    void mudarParaDeletar() throws IOException {
        App.setRoot("teladeletar");
    }
}
