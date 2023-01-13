package com.controllers;

import com.utils.ProfessorDAO;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
public class PesquisaController {

    @FXML
    private Label labelProf;

    @FXML
    private TableView<?> tbProfessores;

    @FXML
    private TextField txCpfprofessor;

    @FXML
    private Label txPesquisa;

    @FXML
    void mudarParaCadastro() {

    }

    @FXML
    void mudarParaDeletar() {

    }

    @FXML
    void mudarParaPesquisar() {

    }

    @FXML
    void pesquisarPorCpf() {
        ProfessorDAO prf = new ProfessorDAO();
        prf.selectByCPF(txCpfprofessor.getText());
    }
}
