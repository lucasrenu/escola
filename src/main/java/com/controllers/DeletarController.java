package com.controllers;

import java.io.IOException;

import com.utils.ProfessorDAO;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class DeletarController {
    @FXML private TextField cpfProfessor;

    @FXML void deletar() {
        ProfessorDAO professor = new ProfessorDAO();
        professor.delete(Integer.parseInt(cpfProfessor.getText())); 
    }

    @FXML void mudarTelaCadastro() throws IOException {
        App.setRoot("telacadastro");
    }

    @FXML void voltarTelaPesquisa() throws IOException {
        App.setRoot("telapesquisa");
    }
}
