package com.controllers;

import java.io.IOException;

import com.classes.Professor;
import com.utils.ProfessorDAO;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

public class PesquisaController {

    @FXML
    private Label lblNome;

    @FXML
    private Label lblCpf;

    @FXML
    private Label lblSalario;

    @FXML
    private Label lblTitulacao;

    @FXML
    private Label lblEspecializacao;

    @FXML
    private Label lblId;

    @FXML
    private Label labelProf;

    @FXML
    private TextField txCpfprofessor;

    @FXML
    private Label txPesquisa;

    @FXML
    private HBox hbDados;

    @FXML
    void mudarParaCadastro() throws IOException {
        App.setRoot("telacadastro");
    }

    @FXML
    void mudarParaDeletar() throws IOException {
        App.setRoot("teladeletar");
    }

    @FXML
    void pesquisarPorCpf() {
        ProfessorDAO prf = new ProfessorDAO();
        //TODO: Válidando entrada de dados, tela de pesquisa por cpf;
        Professor prof = prf.selectByCPF(txCpfprofessor.getText());

        if ( prof != null ){
            hbDados.setVisible(true);
            lblCpf.setText(prof.getCpf());
            lblId.setText(""+prof.getId());
            lblNome.setText(prof.getNome());
            lblSalario.setText(""+prof.getSalario());
            lblTitulacao.setText(prof.getTitulacao());
            lblEspecializacao.setText(prof.getEspecializacao());
            txCpfprofessor.setText("");
        }
    }

    @FXML
    void mudarTelaUpgrade() throws IOException {
        App.setRoot("update");
    }
}
