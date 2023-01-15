package com.controllers;

import java.io.IOException;

import javafx.fxml.FXML;

public class BaseController {
    @FXML
    void mudarTelaDeletar() throws IOException {
        App.setRoot("teladeletar");
    }

    @FXML
    void mudarTelaPesquisa() throws IOException {
        App.setRoot("telapesquisa");
    }

    @FXML
    void mudarTelaUpgrade() throws IOException {
        App.setRoot("update");
    }

    @FXML
    void mudarParaCadastro() throws IOException {
        App.setRoot("telacadastro");
    }
}
